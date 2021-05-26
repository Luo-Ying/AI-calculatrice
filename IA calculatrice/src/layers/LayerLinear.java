package layers;

import java.util.ArrayList;
import java.util.List;

import neurons.*;
import transfertFunctions.ITransfertFunction;
import utils.IInitialiseBias;
import utils.IInitialiseWeights;

public class LayerLinear implements ILayer {
	
	public List<NeuronLinear> neuronList = new ArrayList<NeuronLinear>(); 
	
	public LayerLinear(int inputSize, int outputSize, double lr, IInitialiseWeights initWeights, IInitialiseBias initBias, ITransfertFunction tf) {
		for(int i=0; i<outputSize; i++) {
//			this.neuronList = new List<NeuronLinear>();
			this.neuronList.add(new NeuronLinear(lr,inputSize,initWeights,initBias,tf));
		}
	}
	
	public int size() {
		return neuronList.size();
	}

	@Override
	public double[] forward(double[] input) {
		// TODO Auto-generated method stub
		double[] out = new double[this.size()];
		int pos = 0;
		for(NeuronLinear neuron: neuronList) {		// Boucle for a modifier ...
			out[pos++] = neuron.forward(input);		// Appel la methode forward de neurone
		}
		return out;
	}

	@Override
	public double[] backward(double[] dy) {
		// TODO Auto-generated method stub
		int pos = 0;
		double[] dxt = new double[this.neuronList.get(0).getWSize()];
		for(NeuronLinear neuron: neuronList) {
			dxt = neuron.backward(dxt, dy[pos++]);
		}
		return dxt;
	}

}

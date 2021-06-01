package layers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exceptions.AiExceptionBackward;
import exceptions.AiExceptionForward;
import exceptions.ErrorLevel;
import neurons.*;
import transfertFunctions.ITransfertFunction;
import utils.IInitialiseBias;
import utils.IInitialiseWeights;

public class LayerLinear implements ILayer,Serializable {
	
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
	public double[] forward(double[] input) throws AiExceptionForward {
		// TODO Auto-generated method stub
		try {
			double[] out = new double[this.size()];
			int pos = 0;
			for(NeuronLinear neuron: neuronList) {		// Boucle for a modifier ...
				out[pos++] = neuron.forward(input);		// Appel la methode forward de neurone
			}
			return out;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionForward("Erreur LAYER",ErrorLevel.LAYER);
		}
		
	}

	@Override
	public double[] backward(double[] dy) throws AiExceptionBackward {
		// TODO Auto-generated method stub
		try {
			int pos = 0;
			double[] dxt = new double[this.neuronList.get(0).getWSize()];
			for(NeuronLinear neuron: neuronList) {
				dxt = neuron.backward( dxt,dy[pos++]);
			}
			return dxt;			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionBackward("Erreur LAYER",ErrorLevel.LAYER);
		}
	}

}

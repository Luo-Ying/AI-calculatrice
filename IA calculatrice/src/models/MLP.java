package models;

//import java.util.*;

import layers.LayerLinear;
import losses.ILoss;
import transfertFunctions.ITransfertFunction;
import utils.IInitialiseBias;
import utils.IInitialiseWeights;

public class MLP implements IModel {
	
	private LayerLinear[] layerList;
	private ILoss lossFunction;
	public double loss;
	public double[] input;
	public double[] output;
	public double[] predicted;
	
//	public LossDifference lossFunction = new LossDifference();
	
//	public List<LayerLinear> layerList = new ArrayList<LayerLinear>() ;
	public MLP(int nbLayers, int inputSize, int outputSize, double lr, IInitialiseWeights initWeights, IInitialiseBias initBias, ITransfertFunction tf) {
		this.layerList = new LayerLinear[nbLayers];
		this.input = new double[inputSize];
		this.output = new double[outputSize];
		this.predicted = new double[outputSize];
		for(int i=0; i<nbLayers; i++) {
			this.layerList[i] = new LayerLinear(inputSize, outputSize, lr, initWeights, initBias, tf);
		}
	}
	
	// Calculer l'erreur pour l'afficher dans la console
	public double getLoss (double[] dy) {
		double loss = 0.0;
		for(int i=0; i<dy.length; i++) {
			loss += dy[i];
		}
		return loss /= dy.length;
	}
	
	// Recuperer le plus grand indice contenu dans le tableau pour trouver la valeur predite
	public static int getMaxIndice(double[] t) {
		int max = -1;
		double maxValue = -Double.MIN_VALUE;
		for(int i=0; i<t.length; i++) {
			maxValue = t[i];
			max = i;
		}
		return max;
	}

	@Override
	public double[] forward(double[] input) {
		// TODO Auto-generated method stub
		double[] predicted = input;
		for(int i=0; i<layerList.length; i++) {
			predicted = layerList[i].forward(predicted);	// Appel la methode backward de layer
		}
		return predicted;
	}

	@Override
	public double backward(double[] output, double[] predicted) {
		// TODO Auto-generated method stub
		double[] loss = this.lossFunction.loss(output, predicted);
		for(int i=layerList.length-1; i>=0; i--) {
			loss = layerList[i].backward(loss);		// Appel la methode backward de layer
		}
		return getLoss(loss);
	}

	@Override
	public void learn() {
		// TODO Auto-generated method stub
		
	}
	
}

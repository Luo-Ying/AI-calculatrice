package models;

//import java.util.*;

import layers.LayerLinear;
import losses.ILoss;

public class MLP implements IModel {
	
	private LayerLinear[] layerList;
	private ILoss lossFunction;
	public double loss;
	public double[] input;
	public double[] output;
	public double[] predicted;
	
//	public LossDifference lossFunction = new LossDifference();
	
//	public List<LayerLinear> layerList = new ArrayList<LayerLinear>() ;
//	public MLP(int nbCouche) {
//		this.layerList = new LayerLinear[nbCouche];
//	}
	
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
		for(int i=0; i<layerList.length; i++) {
			input = layerList[i].forward(input);	// Appel la methode backward de layer
		}
		return input;
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

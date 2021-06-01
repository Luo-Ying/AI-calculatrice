package models;

import java.io.Serializable;

//import java.util.*;
import exceptions.*;

import layers.LayerLinear;
import losses.ILoss;
import transfertFunctions.ITransfertFunction;
import utils.IInitialiseBias;
import utils.IInitialiseWeights;

public class MLP implements IModel,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4514812293542656565L;
	
	private LayerLinear[] layerList;
	private ILoss lossFunction;
	public double loss;
	public double[] input;
	public double[] output;
	public double[] predicted;
	
//	public LossDifference lossFunction = new LossDifference();
	
//	public List<LayerLinear> layerList = new ArrayList<LayerLinear>() ;
	public MLP(int nbLayers, int inputSize, int outputSize, double lr, IInitialiseWeights initWeights, IInitialiseBias initBias, ITransfertFunction tf, ILoss lossFunction) {
		this.layerList = new LayerLinear[nbLayers];
		this.input = new double[inputSize];
		this.output = new double[outputSize];
		this.predicted = new double[outputSize];
		this.lossFunction = lossFunction;
		
		int layerOut = (inputSize + outputSize)/nbLayers ;
//		int layerOut = outputSize;
		int layerIn = inputSize;
//		for most problems, one could probably get decent performance (even without a second optimization step) 
//		by setting the hidden layer configuration using just two rules: (i) number of hidden layers equals one; 
//		and (ii) the number of neurons in that layer is the mean of the neurons in the input and output layers.
		
		for(int i=0; i<nbLayers-1; i++) {
			this.layerList[i] = new LayerLinear(layerIn, layerOut, lr, initWeights, initBias, tf);
			layerIn = layerOut;
			layerOut += (layerIn + outputSize)/nbLayers;  
		}
		this.layerList[nbLayers-1] = new LayerLinear(layerIn, outputSize, lr, initWeights, initBias, tf);
	}
	
	// Calculer l'erreur pour l'afficher dans la console
	public double getLoss (double[] dy) throws AiExceptionLoss {
		
		try {
			double loss = 0.0;
			for(int i=0; i<dy.length; i++) {
				loss += dy[i];
			}
			return loss /= dy.length;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionLoss("Erreur MLP",ErrorLevel.MODEL);
		}
	}
	
	// Recuperer le plus grand indice contenu dans le tableau pour trouver la valeur predite
	public static int getMaxIndice(double[] t) {
		int max = -1;
		double maxValue = -Double.MIN_VALUE;
		for(int i=0; i<t.length; i++) {
			if (t[i] > maxValue) {
				
				maxValue = t[i];
				max = i;
			}
		}
		return max;
	}

	@Override
	public double[] forward(double[] input) throws AiExceptionForward {
		// TODO Auto-generated method stub
		
		try {
			double[] predicted = input;
			for(int i=0; i<layerList.length; i++) {
				predicted = layerList[i].forward(predicted);	// Appel la methode backward de layer
			}
			return predicted;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionForward("Erreur MLP",ErrorLevel.MODEL);
		}
	}

	@Override
	public double backward(double[] output, double[] predicted) throws AiExceptionBackward{
		// TODO Auto-generated method stub
		
		try {
			double[] loss = this.lossFunction.loss(output, predicted);
			for(int i=layerList.length-1; i>=0; i--) {
				loss = layerList[i].backward(loss);		// Appel la methode backward de layer
			}
			return getLoss(loss);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionBackward("Erreur MLP",ErrorLevel.MODEL);
		}
		
		
	}

	@Override
	public double learn(double[] input,double[] output) {
		// TODO Auto-generated method stub
		
//		for (double d : output) {
//			System.out.print(" ouput learn: "+d);
//		}
		
		try {
			this.predicted = forward(input);
			loss = backward(output,this.predicted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loss;
	}
	
}

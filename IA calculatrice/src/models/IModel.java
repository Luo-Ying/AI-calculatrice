package models;

import java.util.*;

import exceptions.AiExceptionBackward;
import exceptions.AiExceptionForward;
import neurons.INeuron;

public interface IModel {
	
//	public List<ILayer> layerList = new ArrayList<ILayer>(); 
//	public ILayer[] layerList = null;
	
	public List<INeuron> list = new ArrayList<INeuron>(); 

	public abstract double[] forward(double[] input) throws AiExceptionForward;
	
	public abstract double backward(double[] output, double[] predicted) throws AiExceptionBackward;
	
	public abstract double learn(double[] input, double[] output);
	
}

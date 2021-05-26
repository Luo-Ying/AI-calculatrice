package models;

import java.util.*;

import layers.ILayer;
import neurons.INeuron;

public interface IModel {
	
//	public List<ILayer> layerList = new ArrayList<ILayer>(); 
//	public ILayer[] layerList = null;
	
	public List<INeuron> list = new ArrayList<INeuron>(); 

	public abstract double[] forward(double[] input);
	
	public abstract double backward(double[] output, double[] predicted);
	
	public abstract void learn();
	
}

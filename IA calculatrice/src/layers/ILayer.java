package layers;

import java.util.*;

import neurons.INeuron;

public interface ILayer {
	
	public List<INeuron> neuronList = new ArrayList<INeuron>(); 
	// matrice
	
	public abstract double[] forward(double[] input);
	
	public abstract double[] backward(double[] dy);
	
}

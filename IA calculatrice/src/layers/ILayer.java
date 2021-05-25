package layers;

import java.util.*;

import neurons.INeuron;

public interface ILayer {
	
	public List<INeuron> list = new ArrayList<INeuron>(); 
	// matrice
	
	public abstract double[] formard(double[] input);
	
	public abstract double[] backward(double[] dy);
	
}

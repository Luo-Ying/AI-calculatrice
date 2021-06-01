package layers;

import java.util.*;

import exceptions.AiExceptionBackward;
import exceptions.AiExceptionForward;
import neurons.INeuron;

public interface ILayer {
	
	public List<INeuron> neuronList = new ArrayList<INeuron>(); 
	// matrice
	
	public abstract double[] forward(double[] input) throws AiExceptionForward;
	
	public abstract double[] backward(double[] dy) throws AiExceptionBackward;
	
}

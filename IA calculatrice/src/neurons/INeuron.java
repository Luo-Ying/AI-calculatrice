package neurons;

public interface INeuron {

	public abstract double forward(double[] input) ;
	//  retourne un double repr¨¦sentant la sortie du neurone et prend en param¨¨tre un tableau de double contenant les valeurs d¡¯entr¨¦e;
	
	public abstract double[] backward(double[] Gradient, double dy);
	// retournant l¡¯accumulation du gradient de l¡¯entr¨¦e (tableau de double) et prenant en param¨¨tre ce gradient (tableau de double).
	
	public int getWSize();
	
}

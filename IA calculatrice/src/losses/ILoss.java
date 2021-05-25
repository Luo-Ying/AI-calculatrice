package losses;

public interface ILoss {
	//  la sortie d¨¦sir¨¦e ( Y ) et la sortie pr¨¦dite ( Ypredit )
	
	public abstract double[] loss(double[] Y, double[] Ypredit);
//	a m¨¦thode loss de ILoss qui retournera un tableau de double contenant la diff¨¦rence 
//	entre les deux arguments de la m¨¦thode Y et Ypredit sur chacun des indices
	
}

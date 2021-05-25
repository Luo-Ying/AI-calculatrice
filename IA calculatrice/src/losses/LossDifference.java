package losses;

public class LossDifference implements ILoss {

	@Override
	public double[] loss(double[] Y, double[] Ypredit) {
		// TODO Auto-generated method stub
		int len = Y.length;
		double[] Yd = new double [len];
		for(int i=0; i<len; i++) {
			Y[i] = Y[i] - Ypredit[i];
		}
		return Yd;
	}
	
	
	
}

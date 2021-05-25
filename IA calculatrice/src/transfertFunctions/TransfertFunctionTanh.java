package transfertFunctions;

public class TransfertFunctionTanh implements ITransfertFunction {

	@Override
	public double ft(double v) {
		// TODO Auto-generated method stub
		double e = Math.exp(v);
		double me = Math.exp(-v);
		return ((e - me)/(e + me));
	}

	@Override
	public double dft(double v) {
		// TODO Auto-generated method stub
		return (1 - v * v);
	}

}

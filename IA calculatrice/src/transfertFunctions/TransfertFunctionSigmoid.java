package transfertFunctions;

public class TransfertFunctionSigmoid implements ITransfertFunction {
	
	public double ft(double v) { return (1/ (1 + Math.exp(-v))); }	
	// Math.exp() ����������Ȼ������ e �Ĳ����η�
	
	public double dft(double v) { return (v * (1 - v)); }
	
}

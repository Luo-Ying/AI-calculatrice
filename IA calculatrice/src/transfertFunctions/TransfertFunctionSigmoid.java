package transfertFunctions;

import java.io.Serializable;

public class TransfertFunctionSigmoid implements ITransfertFunction,Serializable {
	
	public TransfertFunctionSigmoid() {
		
	}
	
	public double ft(double v) { return (1/ (1 + Math.exp(-v))); }	
	// Math.exp() 方法返回自然数底数 e 的参数次方
	
	public double dft(double v) { return (v * (1 - v)); }
	
}

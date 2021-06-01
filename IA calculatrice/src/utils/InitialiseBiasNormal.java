package utils;

public class InitialiseBiasNormal implements IInitialiseBias {
	
	public InitialiseBiasNormal() {
		
	}

	@Override
	public double initBias() {
		// TODO Auto-generated method stub
		double initBias = Math.random();
		return initBias;
	}

}

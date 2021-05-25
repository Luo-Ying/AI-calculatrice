package utils;

public class InitialiseWeightsNormal implements IInitialiseWeights {

	@Override
	public double[] initWeights(int size) {
		// TODO Auto-generated method stub
		double[] initWeights = new double[size];
		for(int i=0; i<size; i++) {
			initWeights[i] = Math.random();	
			// 利用该函数可以取得0到1之间的随机小数，如果想得到一个大于1的随机值，则需要再乘以一定的数值来实现。
		}
		return initWeights;
	}

}

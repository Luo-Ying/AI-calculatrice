package utils;

public class InitialiseWeightsNormal implements IInitialiseWeights {

	@Override
	public double[] initWeights(int size) {
		// TODO Auto-generated method stub
		double[] initWeights = new double[size];
		for(int i=0; i<size; i++) {
			initWeights[i] = Math.random();	
			// ���øú�������ȡ��0��1֮������С���������õ�һ������1�����ֵ������Ҫ�ٳ���һ������ֵ��ʵ�֡�
		}
		return initWeights;
	}

}

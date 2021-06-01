package losses;

import java.io.Serializable;

import exceptions.AiExceptionForward;
import exceptions.AiExceptionLoss;
import exceptions.ErrorLevel;

public class LossDifference implements ILoss,Serializable {

	@Override
	public double[] loss(double[] Y, double[] Ypredit) throws AiExceptionLoss {
		// TODO Auto-generated method stub
		try {
			int len = Y.length;
//		for (double d : Y) {
//			System.out.print(" back loss in : "+d);
//		}
//		System.out.println();
			
			double[] Yd = new double [len];
			for(int i=0; i<len; i++) {
				Yd[i] = Y[i] - Ypredit[i] ;
			}
//		for (double d : Yd) {
//			System.out.print(" back loss : "+d);
//		}
//		System.out.println();
			return Yd;			
		} catch (Exception e) {
			// TODO: handle exception
			throw new AiExceptionLoss("Erreur LOSS",ErrorLevel.LOSS);
		}
	}
	
	
	
}

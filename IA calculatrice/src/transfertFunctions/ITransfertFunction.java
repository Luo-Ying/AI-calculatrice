package transfertFunctions;

public interface ITransfertFunction {	//  permettant de calculer la sortie du neurone
	
	
	public abstract double ft(double v);	// fonction de transfert pour la phase de passe avant (forward avec ft)
	public abstract double dft(double v);	// e fonction n¨¦cessaire lors du calcul de la passe arri¨¨re (backward avec dft)

}

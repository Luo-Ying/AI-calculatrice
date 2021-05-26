package neurons;

import transfertFunctions.ITransfertFunction;
import utils.IInitialiseBias;
import utils.IInitialiseWeights;

public class NeuronLinear implements INeuron {
	
	private double[] w;		// representant les poids associe a ce neurone
	public double b;		//  le biais
	public double lr;		// le taux d’apprentissage
	public double[] xt;		// xt[] sauvegardant l’entrée reçue par la méthode forward; 
	double yt;				// yt sauvegardant la sortie générée y (double) par forward
	public ITransfertFunction tf;	// nécessaire dans les algorithmes des méthodes forward et backward de NeuronLinear

	public NeuronLinear(double lr, int inputSize, IInitialiseWeights initW, IInitialiseBias initB, ITransfertFunction tf) {
		this.w = initW.initWeights(inputSize);		// 
		this.b = initB.initBias();
		this.lr = lr;
		this.tf = tf;
	}

	@Override
	public double forward(double[] input) {
		// TODO Auto-generated method stub
		this.xt = input;
		double output = 0.0;
		for(int i=0; i<input.length; i++) {
			output += this.w[i] * input[i];		// ( Figure 1 ) somme
		}
		this.yt = this.tf.ft(output + this.b);	// ( Figure 1 ) function de transfert de somme+b
		return this.yt;
	}

	@Override
	public double[] backward(double[] dxt, double dy) {
		// TODO Auto-generated method stub
		double dxty = this.tf.dft(this.yt) * dy;
		for(int i=0; i<w.length; i++) {
			dxt[i] += this.w[i] * dxty;
			this.w[i] += this.xt[i] * dxty * this.lr;
		}
		this.b += dy * this.lr;
		return dxt;
	}

	@Override
	public int getWSize() {
		// TODO Auto-generated method stub
		return w.length;	// permettant de récupérer la taille de w ainsi qu’un constructeur à 6 arguments permettant d’initialiser NeuronLinear 
	}

}

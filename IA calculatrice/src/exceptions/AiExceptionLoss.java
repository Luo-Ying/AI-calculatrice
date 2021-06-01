package exceptions;

@SuppressWarnings("serial")
public class AiExceptionLoss extends AiException {

	public AiExceptionLoss(String message, ErrorLevel errorLevel) {
		
		super(message, ErrorMethode.LOSS, errorLevel);
		// TODO Auto-generated constructor stub
		
	}
	
	

}

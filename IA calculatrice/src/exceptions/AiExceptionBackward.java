package exceptions;

@SuppressWarnings("serial")
public class AiExceptionBackward extends AiException {
	
	public AiExceptionBackward(String message, ErrorLevel errorLevel) {
		
		super(message, ErrorMethode.BACKWARD, errorLevel);
		// TODO Auto-generated constructor stub
	}

}

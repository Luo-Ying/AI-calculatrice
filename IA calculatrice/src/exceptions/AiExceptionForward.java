package exceptions;

@SuppressWarnings("serial")
public class AiExceptionForward extends AiException {

	public AiExceptionForward(String message, ErrorLevel errorLevel) {
		
		super(message, ErrorMethode.FORWARD, errorLevel);
		// TODO Auto-generated constructor stub
		
	}

}

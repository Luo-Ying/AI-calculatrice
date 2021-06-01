package exceptions;

@SuppressWarnings("serial")
public abstract class AiException extends Exception {

	public ErrorMethode errorMethode;
	public ErrorLevel errorLevel;
	
	public AiException (String message, ErrorMethode errorMethode, ErrorLevel errorLevel) {
		
		super(message);
		this.errorMethode = errorMethode;
		this.errorLevel = errorLevel;
		
	}
	
	public String getMessage() {
		
		String s = super.getMessage() + this.errorMethode + this.errorLevel;
		
		return s;
	}
	
	
}

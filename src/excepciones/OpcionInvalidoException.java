package excepciones;

public class OpcionInvalidoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OpcionInvalidoException(String msg) 
	{
		super(msg);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}

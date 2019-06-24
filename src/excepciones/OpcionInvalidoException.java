package excepciones;

public class OpcionInvalidoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String opcion;

	public OpcionInvalidoException(String msg, String opcion) 
	{
		super(msg);
		this.opcion = opcion;
	}
	
	public String getOpcion()
	{
		return opcion;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage()+" vos ingresaste: "+getOpcion();
	}
}
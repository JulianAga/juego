package excepciones;

public class Excepcion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Excepcion() {

	}

	public String entradaErronea() {
		return "Error, los datos introducidos son erroneos";
	}

}

package herramientas;

public class CajaSorpresa {

	private Pocion pocion = new Pocion();

	public CajaSorpresa() {

	}

	public String sorpresa() {
		String mensaje;
		if (Dado.numeroAleatorio(10) > 5) {
			mensaje = "La caja estaba vacia";
		} else {
			mensaje = "en hora buena, ha encontrado una pocion en la caja";
		}
		return mensaje;
	}
}

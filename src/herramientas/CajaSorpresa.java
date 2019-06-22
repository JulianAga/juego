package herramientas;

import entes.criaturas.JugadorP;

public class CajaSorpresa {

	private Pocion pocion = new Pocion();

	public CajaSorpresa() {

	}

	public String sorpresa(JugadorP j) {
		String mensaje;
		if (Dado.numeroAleatorio(10) > 5) {
			mensaje = "La caja estaba vacia";

		} else {
			mensaje = "en hora buena, ha encontrado una pocion en la caja";
			pocion.tomar(j);
		}
		return mensaje;
	}

}

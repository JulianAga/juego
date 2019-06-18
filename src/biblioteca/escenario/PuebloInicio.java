package biblioteca.escenario;

import entes.criaturas.JugadorP;
import herramientas.Biblioteca;

public class PuebloInicio extends Pueblo {

	@Override
	public void Avanzar(JugadorP p) {
		p.setUbicacion(Biblioteca.Mapa_CaminoNorte());
	}

	@Override
	public void Retroceder(JugadorP p) {

	}

}

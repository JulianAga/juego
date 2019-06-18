package biblioteca.escenario;

import entes.criaturas.JugadorP;
import manager.InteraccionUsuario;

public abstract class Pueblo {

	public void Posada(JugadorP a) {
		if (a.getVidaActual() == a.getVidaMax()) {
			InteraccionUsuario.YaEstasDescansado();
		} else {
			a.RecuperarSalud();
			InteraccionUsuario.TeRecuperastePleno();
		}

	}

	public abstract void Avanzar(JugadorP p);

	public abstract void Retroceder(JugadorP p);
}

package herramientas;

import entes.criaturas.JugadorP;

public class Pocion {

	int vida;

	public Pocion() {
		vida = Dado.numeroAleatorio(10);
	}

	public void tomar(JugadorP j) {
		j.setVidaActual(j.getVidaActual() + vida);
		if (j.getVidaActual() > j.getVidaMax()) {
			j.setVidaActual(j.getVidaMax());
		}
	}
}

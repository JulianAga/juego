package combate;

import habilidades.Habilidad;

public class Atacar {
	/**
	 * 
	 * @param h
	 * @param da�oF
	 * @param da�oM
	 * @param lvl
	 * @param def
	 * @param res
	 * @return
	 */
	public static int CalcularDa�o(Habilidad h, int da�oF, int da�oM, int lvl, int def, int res) {
		if (h.getTipoDa�o().equals("F")) {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oF / def) / 50) + 2;
		} else {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oM / res) / 50) + 2;
		}
	}

}

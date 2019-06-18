package combate;

import habilidades.Habilidad;

public class Atacar {
	/**
	 * 
	 * @param h
	 * @param dañoF
	 * @param dañoM
	 * @param lvl
	 * @param def
	 * @param res
	 * @return
	 */
	public static int CalcularDaño(Habilidad h, int dañoF, int dañoM, int lvl, int def, int res) {
		if (h.getTipoDaño().equals("F")) {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoF / def) / 50) + 2;
		} else {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoM / res) / 50) + 2;
		}
	}

}

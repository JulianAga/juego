package combate;

import habilidades.Habilidad;

/**
 * Esta clase es la que sirve para que el personaje pueda atacar durante el combate.
 *
 */
public class Atacar {
	/**
	 * 
	 * @param h Es la habilidad utilizada.
	 * @param dañoF Es el daño fisico
	 * @param dañoM Es el daño magico
	 * @param lvl Es el nivel del personaje
	 * @param def Es la defensa
	 * @param res Es la resistencia
	 * @return el daño que hace el personaje
	 */
	public static int CalcularDaño(Habilidad h, int dañoF, int dañoM, int lvl, int def, int res) {
		if (h.getTipoDaño().equals("F")) {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoF / def) / 50) + 2;
		} else {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoM / res) / 50) + 2;
		}
	}

}

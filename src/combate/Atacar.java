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
	 * @param da�oF Es el da�o fisico
	 * @param da�oM Es el da�o magico
	 * @param lvl Es el nivel del personaje
	 * @param def Es la defensa
	 * @param res Es la resistencia
	 * @return el da�o que hace el personaje
	 */
	public static int CalcularDa�o(Habilidad h, int da�oF, int da�oM, int lvl, int def, int res) {
		if (h.getTipoDa�o().equals("F")) {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oF / def) / 50) + 2;
		} else {
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oM / res) / 50) + 2;
		}
	}

}

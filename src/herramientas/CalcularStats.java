package herramientas;

import entes.criaturas.JugadorP;

public class CalcularStats {
	/**
	 * Sirve para calcular el hp del personaje
	 * 
	 * @param hpBase
	 * @param hpIndividual
	 * @param nivel        es el nivel del persoanje que la invoca
	 * @return un entero que indica el hp
	 */
	public static int calcularHp(int hpBase, int hpIndividual, int nivel) {
		return ((2 * hpBase + hpIndividual) * nivel) / 100 + nivel + 10;
	}

	/**
	 * Sirve para calcular los stats del personaje
	 * 
	 * @param statBase
	 * @param statIndividual
	 * @param nivel
	 * @return
	 */
	public static int calcularStat(int statBase, int statIndividual, int nivel) {
		return ((2 * statBase + statIndividual) * nivel) / 100 + 5;
	}

	/**
	 * Sirve para calcular el nivel del personaje
	 * 
	 * @param exp Experiencia
	 * @return un entero que es el nivel
	 */
	public static int calcularNivel(int exp) {
		return (int) Math.pow(exp, 1.0 / 3.0);
	}

	/**
	 * Aumenta la experiencia de un jugadorP por nivel
	 */

	public static int aumentarExp(JugadorP a, JugadorP b) {
		return (int) (b.getExpBase() * b.getNivel() / 5 * Math.pow(2 * b.getNivel() + 10, 2.5)
				/ Math.pow(b.getNivel() + a.getNivel() + 10, 2.5) + 1);
	}

	public static int setearExp(int nivel) {
		return (int) Math.pow(nivel, 3);
	}
}

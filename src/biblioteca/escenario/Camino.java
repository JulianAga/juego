package biblioteca.escenario;

import entes.criaturas.JugadorP;

public abstract class Camino {

	protected static int ubicacion;
	protected static int numero;
	protected static int opcion;
	protected static JugadorP p;
	protected static int dificultad; // Determina el nivel de los npc que puedan aparecer
	protected static boolean flag;

	/**
	 * Hace que el personaje avance. Es abstracta y cada clase debe sobreescribirlo.
	 * @param Personaje
	 */
	public abstract void Avanzar(JugadorP a);

	/**
	 * Hace que el personaje retroceda. Es abstracta y cada clase debe sobreescribirlo.
	 * @param Personaje
	 */
	public abstract void Retroceder(JugadorP a);

}

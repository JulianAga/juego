package biblioteca.escenario;

import entes.criaturas.JugadorP;

public abstract class Camino {

	protected static int ubicacion;
	protected static int numero;
	protected static int opcion;
	protected static JugadorP p;
	protected static int dificultad; // Determina el nivel de los npc que puedan aparecer
	protected static boolean flag;

	public abstract void Avanzar(JugadorP a);

	public abstract void Retroceder(JugadorP a);

}

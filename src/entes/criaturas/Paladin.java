package entes.criaturas;

import herramientas.Biblioteca;

/**
 * Clase "Paladin" que hereda de "JugadorP". Los atributos que posee son
 * est�ticos y son las estad�sticas base que tiene cada personaje de clase
 * Paladin. Sus stats base suman 500.
 *
 */
public class Paladin extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Palad�n.

	private final static int vidaMax = 110;
	private final static int defensa = 100;
	private final static int recistencia = 80;
	private final static int da�oF = 110;
	private final static int da�oM = 50;
	private final static int velocidad = 50;
	private final static String clase = "paladin";
	private final static int expBase = 100;

	public Paladin() {
		super();
	}

	/**
	 * Crea una instancia de palad�n y carga las habilidades correspondientes.
	 * 
	 * @param level El nivel con el que se quiera crear a dicho personaje.
	 */
	public Paladin(int level) {
		super(vidaMax, defensa, recistencia, da�oF, da�oM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesPaladin());
	}

}

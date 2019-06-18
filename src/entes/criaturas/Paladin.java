package entes.criaturas;

import herramientas.Biblioteca;

/**
 * Clase "Paladin" que hereda de "JugadorP". Los atributos que posee son estáticos y son las estadísticas base que tiene cada personaje de clase Paladin.
 * Sus stats base suman 500.
 *
 */
public class Paladin extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Paladín.

	private final static int vidaMax = 110;
	private final static int defensa = 100;
	private final static int recistencia = 80;
	private final static int dañoF = 110;
	private final static int dañoM = 50;
	private final static int velocidad = 50;
	private final static String clase = "Ladron";
	private final static int expBase = 100;



	public Paladin() {
		super();
	}

	/**
	 * Crea una instancia de paladín y carga las habilidades correspondientes.
	 * 
	 * @param level El nivel con el que se quiera crear a dicho personaje.
	 */
	public Paladin(int level) {
		super(vidaMax, defensa, recistencia, dañoF, dañoM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesLadron());
	}

}

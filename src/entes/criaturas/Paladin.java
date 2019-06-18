package entes.criaturas;

import herramientas.Biblioteca;

public class Paladin extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Ladrón.

	private final static int vidaMax = 110;
	private final static int defensa = 100;
	private final static int recistencia = 80;
	private final static int dañoF = 110;
	private final static int dañoM = 50;
	private final static int velocidad = 50;
	private final static String clase = "Ladron";
	private final static int expBase = 100;

	// Total de stats base = 500.

	public Paladin() {
		super();
	}

	/**
	 * Crea una instancia de ladron y carga las habilidades correspondientes.
	 * 
	 * @param level El nivel con el que se quiera crear a dicho personaje.
	 */
	public Paladin(int level) {
		super(vidaMax, defensa, recistencia, dañoF, dañoM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesLadron());
	}

}

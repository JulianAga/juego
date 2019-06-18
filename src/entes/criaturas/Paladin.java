package entes.criaturas;

import herramientas.Biblioteca;

public class Paladin extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Ladr�n.

	private final static int vidaMax = 110;
	private final static int defensa = 100;
	private final static int recistencia = 80;
	private final static int da�oF = 110;
	private final static int da�oM = 50;
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
		super(vidaMax, defensa, recistencia, da�oF, da�oM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesLadron());
	}

}

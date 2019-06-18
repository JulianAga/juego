package entes.criaturas;

import herramientas.Biblioteca;

public class Ladron extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Ladrón.

	private final static Integer vidaMax = 65;
	private final static Integer defensa = 90;
	private final static Integer recistencia = 65;
	private final static Integer dañoF = 120;
	private final static Integer dañoM = 50;
	private final static Integer velocidad = 10; // 110
	private final static String clase = "Ladron";
	private final static Integer expBase = 100;

	// Total de stats base = 500.
	/*
	 * public Ladron() { super(); }
	 */
	/**
	 * Crea una instancia de ladron y carga las habilidades correspondientes.
	 * 
	 * @param level El nivel con el que se quiera crear a dicho personaje.
	 */
	public Ladron(int level) {
		super(vidaMax, defensa, recistencia, dañoF, dañoM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesLadron());
	}

}

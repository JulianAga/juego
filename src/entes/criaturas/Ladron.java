package entes.criaturas;

import herramientas.Biblioteca;

/**
 * Clase "Ladron" que hereda de "JugadorP". Los atributos que posee son est�ticos y son las estad�sticas base que tiene cada personaje de clase Ladr�n.
 * Sus stats base suman 500.
 */
public class Ladron extends JugadorP {

	/// Estas estadisticas son las base que tiene cada personaje de clase Ladr�n.

	private final static Integer vidaMax = 65;
	private final static Integer defensa = 90;
	private final static Integer recistencia = 65;
	private final static Integer da�oF = 120;
	private final static Integer da�oM = 50;
	private final static Integer velocidad = 10; // 110
	private final static String clase = "Ladron";
	private final static Integer expBase = 100;

	/*
	 * public Ladron() { super(); }
	 */
	/**
	 * Crea una instancia de ladron y carga las habilidades correspondientes.
	 * 
	 * @param level El nivel con el que se quiera crear a dicho personaje.
	 */
	public Ladron(int level) {
		super(vidaMax, defensa, recistencia, da�oF, da�oM, velocidad, level, clase, expBase);
		setHabilidades(Biblioteca.CargarHabilidadesLadron());
	}

}

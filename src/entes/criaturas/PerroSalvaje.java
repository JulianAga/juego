package entes.criaturas;

import herramientas.Biblioteca;

/**
 * Clase "Perro Salvaje" que hereda de "JugadorP". Los atributos que posee son estáticos y son las estadísticas base que tiene cada personaje de clase Perro Salvaje.
 *
 */
public class PerroSalvaje extends JugadorP {

	private final static int vidaMax = 15;
	private final static int defensa = 15;
	private final static int resistencia = 5;
	private final static int dañoF = 20;
	private final static int dañoM = 20;
	private final static int velocidad = 40;
	private final static String clase = "PerroSalvaje";
	private final static int experienciaBase = 50;

	public PerroSalvaje() {
		super();
	}

	/**
	 * Crea una instancia de perro salvaje
	 * 
	 * @param level el nivel con el que queres que se cree el perro
	 */
	public PerroSalvaje(int level) {
		super(vidaMax, defensa, resistencia, dañoF, dañoM, velocidad, level, clase, experienciaBase);
		setHabilidades(Biblioteca.CargarHabilidadesPerro());
	}
}

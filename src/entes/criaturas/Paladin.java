package entes.criaturas;

import graficos.Sprite;
import herramientas.Biblioteca;

public class Paladin extends Jugador {

	/// Estas estadisticas son las base que tiene cada personaje de clase Ladr�n.

	Sprite sprite;
	private final static int vidaMax = 110;
	private final static int defensa = 100;
	private final static int resistencia = 80;
	private final static int da�oF = 110;
	private final static int da�oM = 50;
	private final static int velocidad = 50;
	private final static String clase = "Ladron";
	private final static int expBase = 100;

	private static int nivel = 1;

	public Paladin(int level) {
		super(null, null, null, vidaMax, defensa, resistencia, da�oF, da�oM, velocidad, null, null, null, clase,
				expBase);
		setHabilidades(Biblioteca.CargarHabilidadesPaladin());
	}

}

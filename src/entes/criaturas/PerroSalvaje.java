package entes.criaturas;

public class PerroSalvaje extends Criatura {

	private int vidaMax = 15;
	private int defensa = 15;
	private int resistencia = 5;
	private int dañoF = 20;
	private int dañoM = 20;
	private int velocidad = 40;
	private String clase = "PerroSalvaje";
	private int experienciaBase = 50;

	public PerroSalvaje(int vidaMax, int defensa, int resistencia, int dañoF, int dañoM, int velocidad, String clase,
			int experienciaBase) {
		super();
		this.vidaMax = vidaMax;
		this.defensa = defensa;
		this.resistencia = resistencia;
		this.dañoF = dañoF;
		this.dañoM = dañoM;
		this.velocidad = velocidad;
		this.clase = clase;
		this.experienciaBase = experienciaBase;
	}

	public PerroSalvaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea una instancia de perro salvaje
	 * 
	 * @param level el nivel con el que queres que se cree el perro
	 */

}

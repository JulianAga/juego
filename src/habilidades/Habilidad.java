package habilidades;

/**
 * Esta clase contiene el constructor, getters y setters de las habilidades.
 * Aqui se define su nombre, su costo, entre otros atributos.
 *
 */
public class Habilidad implements HabilidadEspecial {

	private String nombre;
	private String tipoDaño; // Tipo de daño posible es F (fisico) o M (magico) (por ahora....)
	private int potencia;
	private int costoMana;
	private int nivelDesbloqueo;
	private int prioridad;

	/**
	 * Crea una instancia vacía de la clase "Habilidad".
	 */
	public Habilidad() {
		nombre = "";
		tipoDaño = "";
		potencia = 0;
		costoMana = 0;
	}

	/**
	 * Crea una instancia de la clase "Habilidad" con todos sus argumentos pasados
	 * por parametro.
	 */
	public Habilidad(String nombre, String tipoDaño, int potencia, int costoMana, int nivelDesbloqueo, int prioridad) {
		this.nombre = nombre;
		this.tipoDaño = tipoDaño;
		this.potencia = potencia;
		this.costoMana = costoMana;
		this.nivelDesbloqueo = nivelDesbloqueo;
		this.prioridad = prioridad;
	}

	/**
	 * Muestra la habilidad por pantalla.
	 */
	public void MostrarHabilidad() {
		System.out.println(getNombre() + " Daño: " + getTipoDaño() + " Potencia: " + getPotencia() + " Costo mana: "
				+ getCostoMana());
		System.out.println("------------------------");
	}

	public int getPrioridad() {
		return prioridad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipoDaño() {
		return tipoDaño;
	}

	public float getPotencia() {
		return potencia;
	}

	public int getCostoMana() {
		return costoMana;
	}

	public int getNivelDesbloqueo() {
		return nivelDesbloqueo;
	}

	@Override
	public int lanzarHabilidad() {
		return potencia * 2;
	}
}

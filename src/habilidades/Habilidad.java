package habilidades;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Esta clase contiene el constructor, getters y setters de las habilidades.
 * Aqui se define su nombre, su costo, entre otros atributos.
 *
 */
public class Habilidad implements HabilidadEspecial {

	private String nombre;
	private String tipoDaño; // Tipo de daño posible es F (fisico) o M (magico) (por ahora....)
	private int potencia;
	private int nivelDesbloqueo;
	private int prioridad;

	/**
	 * Crea una instancia vacía de la clase "Habilidad".
	 */
	public Habilidad() {
		nombre = "";
		tipoDaño = "";
		potencia = 0;
	}

	/**
	 * Crea una instancia de la clase "Habilidad" con todos sus argumentos pasados
	 * por parametro.
	 */
	public Habilidad(String nombre, String tipoDaño, int potencia, int nivelDesbloqueo, int prioridad) {
		this.nombre = nombre;
		this.tipoDaño = tipoDaño;
		this.potencia = potencia;
		this.nivelDesbloqueo = nivelDesbloqueo;
		this.prioridad = prioridad;
	}


	
	public JSONObject getFormatoJSONObject() throws JSONException
	{
		JSONObject obj = new JSONObject();
		obj.put("nombre",getNombre());
		obj.put("tipo daño",getTipoDaño());
		obj.put("potencia",getPotencia());
		obj.put("nivel desbloqueo", getNivelDesbloqueo());
		obj.put("prioridad",getPrioridad());
		return obj;
	}
	
	
	/**
	 * Muestra la habilidad por pantalla.
	 */
	public void MostrarHabilidad() {
		System.out.println(getNombre() + " Daño: " + getTipoDaño() + " Potencia: " + getPotencia());
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


	public int getNivelDesbloqueo() {
		return nivelDesbloqueo;
	}

	@Override
	public int lanzarHabilidad() {
		return potencia * 2;
	}
}

package herramientas;

import java.util.ArrayList;

import habilidades.Habilidad;

public class Biblioteca {

	/**
	 * Escenario.  Acá se retornan los strings para usar más adelante.
	 */
	public static String Mapa_PuebloInicio() {
		return "Pueblo Inicio";
	}

	/**
	 * Escenario.  Acá se retornan los strings para usar más adelante.
	 */
	public static String Mapa_CaminoNorte() {
		return "Camino Norte";
	}

	/**
	 * Escenario.  Acá se retornan los strings para usar más adelante.
	 */
	public static String Mapa_PuebloSegundo() {
		return "Pueblo Segundo";
	}

	/**
	*Este metodo se usa para cargarle las habilidades a un personaje nuevo del tipo ladron.
	*@param Habilidad Nombre de la habilidad.
	* @param Daño Tipo de daño (F o M) 
	* @param Potencia Para calcular daño 
	* @param Maná Costo de maná 
	* @param Nivel Nivel en el que el personaje puede usar dicha habilidad
	* @param Prioridad Velocidad de la habilidad
	*/
	public static ArrayList<Habilidad> CargarHabilidadesLadron() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Facazo", "F", 40, 0, 0, 1));
		h.add(new Habilidad("Golpe Rápido", "F", 60, 0, 2, 2));
		return h;
	}

	/**
	*Este metodo se usa para cargarle las habilidades a un personaje nuevo del tipo perro.
	*@param Habilidad Nombre de la habilidad.
	* @param Daño Tipo de daño (F o M) 
	* @param Potencia Para calcular daño 
	* @param Maná Costo de maná 
	* @param Nivel Nivel en el que el personaje puede usar dicha habilidad
	* @param Prioridad Velocidad de la habilidad
	*/
	public static ArrayList<Habilidad> CargarHabilidadesPerro() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new habilidades.Habilidad("Mordisco", "F", 30, 0, 0, 1));
		return h;
	}

	/**
	*Este metodo se usa para cargarle las habilidades a un personaje nuevo del tipo paladin.
	*@param Habilidad Nombre de la habilidad.
	* @param Daño Tipo de daño (F o M) 
	* @param Potencia Para calcular daño 
	* @param Maná Costo de maná 
	* @param Nivel Nivel en el que el personaje puede usar dicha habilidad
	* @param Prioridad Velocidad de la habilidad
	*/
	public static ArrayList<Habilidad> CargarHabilidadesPaladin() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Espada Ancha", "F", 60, 0, 0, 1));
		h.add(new Habilidad("Golpe Pesado", "F", 90, 0, 2, 0));
		return h;
	}

	/**
	*Este metodo se usa para cargarle las habilidades a un personaje nuevo del tipo mago.
	*@param Habilidad Nombre de la habilidad.
	* @param Daño Tipo de daño (F o M) 
	* @param Potencia Para calcular daño 
	* @param Maná Costo de maná 
	* @param Nivel Nivel en el que el personaje puede usar dicha habilidad
	* @param Prioridad Velocidad de la habilidad
	*/
	public static ArrayList<Habilidad> CargarHabilidadesMago() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Golpe Baston", "F", 30, 0, 0, 1));
		h.add(new Habilidad("Bola de Fuego Menor", "F", 50, 5, 0, 1));
		return h;
	}
}

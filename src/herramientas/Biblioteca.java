package herramientas;

import java.util.ArrayList;

import habilidades.Habilidad;

public class Biblioteca {

	// Escenarios. Acá se retornan los strings para usar más adelante.
	public static String Mapa_PuebloInicio() {
		return "Pueblo Inicio";
	}

	public static String Mapa_CaminoNorte() {
		return "Camino Norte";
	}

	public static String Mapa_PuebloSegundo() {
		return "Pueblo Segundo";
	}

	// Esta parte se usa para cargarle las habilidades a un personaje nuevo
	// discriminandolo por
	// clase.
	// Los parametros son 1.Nombre de la habilidad 2.Tipo de daño (F o M) 3.Potencia
	// (para calcular
	// daño 4.Costo de maná 5.Nivel en el que el personaje puede usar dicha
	// habilidad
	// 5.Prioridad (velocidad de la habilidad)

	public static ArrayList<Habilidad> CargarHabilidadesLadron() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Facazo", "F", 40, 0, 0, 1));
		h.add(new Habilidad("Golpe Rápido", "F", 60, 0, 2, 2));
		return h;
	}

	public static ArrayList<Habilidad> CargarHabilidadesPerro() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new habilidades.Habilidad("Mordisco", "F", 30, 0, 0, 1));
		return h;
	}

	public static ArrayList<Habilidad> CargarHabilidadesPaladin() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Espada Ancha", "F", 60, 0, 0, 1));
		h.add(new Habilidad("Golpe Pesado", "F", 90, 0, 2, 0));
		return h;
	}

	public static ArrayList<Habilidad> CargarHabilidadesMago() {
		ArrayList<Habilidad> h = new ArrayList<Habilidad>();
		h.add(new Habilidad("Golpe Baston", "F", 30, 0, 0, 1));
		h.add(new Habilidad("Bola de Fuego Menor", "F", 50, 5, 0, 1));
		return h;
	}
}

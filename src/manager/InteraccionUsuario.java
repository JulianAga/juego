package manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import entes.criaturas.JugadorP;
import habilidades.Habilidad;
import herramientas.Dado;

/**
 * Esta clase posee toda la interacción que tiene el programa con el usuario. Es
 * decir, posee las cosas que se le muestran por consola, cuando un usuario debe
 * elegir una opción y el inicio del juego.
 *
 */
public class InteraccionUsuario {

	private static Scanner scr;

	// Metodos utilizados en pueblos.
	public static int OpcionesPuebloInicio() {
		System.out.println("Estas en el pueblo de inicio....Que deseas hacer?");
		System.out.println("1.Descansar en la posada (Gratis)");
		System.out.println("2.Avanzar");
		System.out.println("3.Retroceder");
		int opcion = ElegirOpcion();
		clearScreen();
		return opcion;
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void FinDelCamino() {
		System.out.println("Fin del camino");
	}

	public static void TeRecuperastePleno() {
		System.out.println("Te recuperaste a pleno! ATR");
	}

	public static void YaEstasDescansado() {
		System.out.println("Ya estás descansado!");
	}

	// Metodos para mostrar personajes
	public static void MostrarClaveValor(LinkedHashMap<String, Integer> stats, String clave) {
		System.out.println(clave + ": " + stats.get(clave));
	}

	public static void MostrarStatsPersonaje(LinkedHashMap<String, Integer> stats) {
		stats.forEach((k, v) -> System.out.println(k + ": " + v));
	}

	public static void MostrarVida(int vidaMax) {
		System.out.println(" Vida: " + "/" + vidaMax);
	}

	public static void MostrarVidaActual(int vida) {
		System.out.println(" Vida: " + "/" + vida);
	}

	public static void MostrarMana(int mana) {
		System.out.println("Mana: " + mana);
	}

	public static int MostrarHabilidades(JugadorP a) {
		int contador = 0;
		System.out.println("Habilidades de " + a.getClase());
		System.out.println("Apreta 1 para usar tu habilidad");
		ArrayList<Habilidad> habilidades = a.getHabilidades();
		for (Habilidad h : habilidades) {
			if (a.getNivel() >= h.getNivelDesbloqueo()) {
				contador++;
				System.out.println(contador);
				h.MostrarHabilidad();
			}
		}
		return contador;
	}

	// Metodos de ingreso por teclado
	public static Habilidad ElegirHabilidadAleatoria(JugadorP a) {
		int numero;
		ArrayList<Habilidad> habilidades = a.getHabilidades();
		numero = Dado.numeroAleatorio(habilidades.size());
		return a.getHabilidad(numero);
	}

	public static Habilidad ElegirHabilidad(JugadorP a) {
		int cant;
		int opcion;
		cant = MostrarHabilidades(a);
		opcion = ElegirOpcion();
		return a.getHabilidad(opcion - 1);
	}

	public static int ElegirOpcion() {
		scr = new Scanner(System.in);
		return scr.nextInt();
	}
	// Metodos varios

	public static void OpcionInvalida() {
		System.out.println("Opcion invalida");
	}

	// Metodos usados en combates
	public static void Ataque(String clase, Habilidad h) {
		System.out.println(clase + " usó " + h.getNombre());
	}

	public static void LograsEscapar() {
		System.out.println("Logas escapar");
	}

	public static void NoPuedesEscapar() {
		System.out.println("No puedes escapar!");
	}

	public static int Encounter(String clase) {
		int numero;
		System.out.println("Te encontrás con un " + clase + "....");
		System.out.println("1.Te plantas" + "  " + "2.Rajás?");
		numero = ElegirOpcion();
		return numero;
	}

	public static void SosVictorioso() {
		System.out.println("Saliste victorioso.");
	}

	public static void pocion() {
		System.out.println("has encontrado una pocion");
	}

	public static void cajaSorpresa() {
		System.out.println("has encontrado una caja sorpresa");

	}

	// Opciones del camino
	public static int OpcionesCamino(String camino) {
		System.out.println("Estas en el camino " + camino + "....Que deseas hacer?");
		System.out.println("1.Caminar norte");
		System.out.println("2.Caminar sur");
		int opcion = ElegirOpcion();
		return opcion;
	}

	public static void AvanzasElCamino() {
		System.out.println("Avanzas por el camino.");
	}

	public static void RetrocedesElCamino() {
		System.out.println("Retrocedes por el camino.");
	}

	public static int FinalCamino(String puebloProximo) {
		System.out.println("Llegaste al final del camino. Que haces?");
		System.out.println("1.Ir al pueblo proximo: " + puebloProximo);
		System.out.println("2.Cambiar rumbo");
		int opcion = ElegirOpcion();
		return opcion;
	}

	public static void InicioJuego() {
		System.out.println("BIENVENIDO");
		System.out.println("Elegir Clase");
		System.out.println("1.Ladrón");
		System.out.println("2.Paladín");
	}
}

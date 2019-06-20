package combate;

import java.util.Random;

import entes.criaturas.JugadorP;
import habilidades.Habilidad;
import herramientas.CalcularStats;
import manager.InteraccionUsuario;

/**
 * Esta clase contiene los m�todos para que dos personajes entren en combate.
 *
 */
public class MetodosCombate {
	private static int da�o;
	private static Habilidad h;
	private static Habilidad g;
	private static Random rand;

	/**
	 * Mecanicas del combate
	 * 
	 * @param a Nuestro personaje
	 * @param b Enemigo
	 */
	public static void Combate(JugadorP a, JugadorP b) {
		da�o = 0;
		rand = new Random();
		while (a.getVidaActual() > 0 && b.getVidaActual() > 0)// Chequea que ambos contrincantes esten vivos.
		{
			a.mostrarVida();// aca tenemos que poner de quien es cada vida porque solo aparece el numero
			b.mostrarVida();
			h = InteraccionUsuario.ElegirHabilidad(a); // Ambos contrincantes eligen la
			g = InteraccionUsuario.ElegirHabilidadAleatoria(b); // habilidad que vayan a usar.

			if (h.getPrioridad() == g.getPrioridad()) {
				if (1 == CalcularPrioridad(a, b)) {
					EfectuarAtaque(a, b, h);
					if (SigueConVida(b))
						EfectuarAtaque(b, a, g);
				} else if (-1 == CalcularPrioridad(a, b)) {
					EfectuarAtaque(b, a, g);
					if (SigueConVida(a))
						EfectuarAtaque(a, b, h);
				} else if (0 == CalcularPrioridad(a, b)) {
					if (1 == PrioridadAleatoria()) {
						EfectuarAtaque(a, b, h);
						if (SigueConVida(b))
							EfectuarAtaque(b, a, g);
					} else if (0 == PrioridadAleatoria()) {
						EfectuarAtaque(b, a, g);
						if (SigueConVida(a))
							EfectuarAtaque(a, b, h);
					}
				}
			} else if (h.getPrioridad() > g.getPrioridad()) {
				EfectuarAtaque(a, b, h);
				if (SigueConVida(b))
					EfectuarAtaque(b, a, g);
			} else if (h.getPrioridad() < g.getPrioridad()) {
				EfectuarAtaque(b, a, g);
				if (SigueConVida(a))
					EfectuarAtaque(a, b, h);
			}
		}
		if (a.getVidaActual() > 0) // Eval�a si el jugador gan� y le asigna la experiencia
		{
			atribuirExp(a, b);
			InteraccionUsuario.SosVictorioso();
		}
		if (a.getVidaActual() <= 0) {
			a.Muerte();
		}
	}

	/**
	 * Se le da la experiencia al personaje y si es necesario, se le sube el nivel. 
	 * @param a
	 * @param b
	 */
	private static void atribuirExp(JugadorP a, JugadorP b) {
		a.setExp(CalcularStats.aumentarExp(a, b));
		a.setNivel(CalcularStats.calcularNivel(a.getExp()));
	}

	private static int PrioridadAleatoria() {
		return rand.nextInt(2);
	}

	/**
	 * Se produce el ataque de un personaje a otro.
	 * @param a Personaje que efectua el ataque
	 * @param b Personaje que recibe el ataque
	 * @param h Habilidad que usa el atacante
	 */
	private static void EfectuarAtaque(JugadorP a, JugadorP b, Habilidad h) {
		InteraccionUsuario.Ataque(a.getClase(), h); // Muestra por pantalla qu� ataque se efectu� (el nombre)
		da�o = CalcularDa�o(h, a.getDa�oF(), a.getDa�oM(), a.getNivel(), b.getResistenciaF(), b.getResistenciaM());
		b.QuitarVida(da�o);
	}

	/**
	 * Verifica si seguimos vivos
	 * 
	 * @param a Nuestro personaje
	 * @return true si estas vivo, false si estas muerto
	 */
	private static boolean SigueConVida(JugadorP a) {
		if (a.getVidaActual() > 0)
			return true;
		else {
			a.Muerte();
			return false;
		}
	}

	/**
	 * Calcula el da�o que hace cierta habilidad.
	 * @param h Habilidad
	 * @param da�oF Da�o fisico
	 * @param da�oM Da�o magico
	 * @param lvl Nivel
	 * @param def Defensa
	 * @param res Resistencia
	 * @return Un entero que representa el da�o que hace.
	 */
	public static int CalcularDa�o(Habilidad h, int da�oF, int da�oM, int lvl, int def, int res) {
		if (h.getTipoDa�o().equals("F")) // Si la habilidad usada es da�o F(fisico) usa la
											// variable "da�oF" para calcular el da�o
		{
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oF / def) / 50) + 2;
		} else // De lo contrario usa "da�oM" o da�o m�gico
		{
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * da�oM / res) / 50) + 2;
		}
	}

	/**
	 * Calcula cual de los dos personajes tiene la prioridad de ataque.
	 * @param a Personaje A
	 * @param b Personaje B
	 * @return Un entero que puede ser -1 si la prioridad la tiene el personaje A o 0 si la prioridad la tiene el personaje B.
	 */
	private static int CalcularPrioridad(JugadorP a, JugadorP b) {
		if (a.getVelocidad() > b.getVelocidad())
			return 1;
		else if (a.getVelocidad() < b.getVelocidad())
			return -1;
		else
			return 0;
	}

}

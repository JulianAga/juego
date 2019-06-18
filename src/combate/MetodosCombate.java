package combate;

import java.util.Random;

import entes.criaturas.JugadorP;
import habilidades.Habilidad;
import herramientas.CalcularStats;
import manager.InteraccionUsuario;

public class MetodosCombate {
	private static int daño;
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
		daño = 0;
		rand = new Random();
		while (a.getVidaActual() > 0 && b.getVidaActual() > 0)// Chequea que ambos contrincantes esten vivos.
		{
			a.mostrarVida();
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
		if (a.getVidaActual() > 0) // Evalúa si el jugador ganó y le asigna la experiencia
		{
			atribuirExp(a, b);
			InteraccionUsuario.SosVictorioso();
		}
		if (a.getVidaActual() <= 0) {
			a.Muerte();
		}
	}

	/**
	 * 
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
	 * 
	 * @param a
	 * @param b
	 * @param h
	 */
	private static void EfectuarAtaque(JugadorP a, JugadorP b, Habilidad h) {
		InteraccionUsuario.Ataque(a.getClase(), h); // Muestra por pantalla qué ataque se efectuó (el nombre)
		daño = CalcularDaño(h, a.getDañoF(), a.getDañoM(), a.getNivel(), b.getResistenciaF(), b.getResistenciaM());
		b.QuitarVida(daño);
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
	 * 
	 * @param h
	 * @param dañoF
	 * @param dañoM
	 * @param lvl
	 * @param def
	 * @param res
	 * @return
	 */
	public static int CalcularDaño(Habilidad h, int dañoF, int dañoM, int lvl, int def, int res) {
		if (h.getTipoDaño().equals("F")) // Si la habilidad usada es daño F(fisico) usa la
											// variable "dañoF" para calcular el daño
		{
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoF / def) / 50) + 2;
		} else // De lo contrario usa "dañoM" o daño mágico
		{
			return (int) (((2 * lvl / 5 + 2) * h.getPotencia() * dañoM / res) / 50) + 2;
		}
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
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

package entes.criaturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

//ACA IRIAN LOS IMPORTS DEL JSON

import control.Teclado;
import entes.Ente;
import excepciones.OpcionInvalidoException;
import graficos.Pantalla;
import graficos.Sprite;
import habilidades.Habilidad;
import manager.Manager;
import mapa.Mapa;

public class Jugador extends Criatura {

	public static Manager pelea;

	/**
	 * Estas variables representan las estadísticas individuales que pueden tener
	 * los personajes. Son numeros al azar entre 1 y 31 y sirven, en conjunto con
	 * las estadísticas base de la clase, para calcular las estadísticas finales del
	 * personaje tanto cuando es creado como cuando sube de nivel.
	 */
	private HashMap<String, Integer> statsI;

	/**
	 * Son las estadísticas finales y visibles que posee un personaje una vez se lo
	 * calcula en referencia a las estadísticas individuales (del personaje) y base
	 * (de la clase).
	 */
	private LinkedHashMap<String, Integer> stats;

// Las claves utilizadas en los HashMap
	private final String vidaActual = "Vida actual";
	private String vidaMax = "vidaMax";
	private final String resistenciaF = "Resistencia f";
	private final static String resistenciaM = "Resistencia m";
	private final String dañoF = "Daño f";
	private final String dañoM = "Daño m";
	private final String velocidad = "Velocidad";
	private final String exp = "Exp";
	private final String nivel = "Nivel";

	private ArrayList<Habilidad> habilidades;

	private boolean conVida;

	private String ubicacion;

	private String clase;
	/*
	 * private int vidaActual; private int vidaMax; private int defensa; private int
	 * recistencia; private int dañoF; private int dañoM; private int exp; private
	 * int level;
	 */

	public String getClase() {
		return clase;
	}

	/**
	 * Crea una instancia de la clase Jugador con todos sus atributos pasados por
	 * parámetro.
	 */
	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
		Ente.mapa = mapa;
		Jugador.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;

	}

	protected static Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		Ente.mapa = mapa;
		Jugador.teclado = teclado;
		this.sprite = sprite;
		statsI = new HashMap<>();
		stats = new LinkedHashMap<>();
		habilidades = new ArrayList<Habilidad>();
	}

	@Override
	public void actualizar() throws OpcionInvalidoException {

		int desplazamientoX = 0;
		int desplazamientoY = 0;

		int velocidadMovimiento = 1;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			velocidadMovimiento = 2;
		}

		if (teclado.arriba) {
			desplazamientoY -= velocidadMovimiento;
		}
		if (teclado.abajo) {
			desplazamientoY += velocidadMovimiento;
		}
		if (teclado.izquierda) {
			desplazamientoX -= velocidadMovimiento;
		}
		if (teclado.derecha) {
			desplazamientoX += velocidadMovimiento;
		}

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		int resto = animacion % 40;

		if (direccion == 'n') {
			sprite = Sprite.ARRIBA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.ARRIBA1;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.ARRIBA0;
				} else if (resto > 30) {
					sprite = Sprite.ARRIBA2;
				} else {
					sprite = Sprite.ARRIBA0;
				}
			}
		}
		if (direccion == 's') {
			sprite = Sprite.ABAJO0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.ABAJO1;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.ABAJO0;
				} else if (resto > 30) {
					sprite = Sprite.ABAJO2;
				} else {
					sprite = Sprite.ABAJO0;
				}
			}
		}
		if (direccion == 'o') {
			sprite = Sprite.IZQUIERDA0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.IZQUIERDA1;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.IZQUIERDA0;
				} else if (resto > 30) {
					sprite = Sprite.IZQUIERDA2;
				} else {
					sprite = Sprite.IZQUIERDA0;
				}
			}
		}
		if (direccion == 'e') {
			sprite = Sprite.DERECHA0;
			if (enMovimiento) {
			} else if (resto > 20 && resto <= 30) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.DERECHA1;
					sprite = Sprite.DERECHA0;
				} else if (resto > 30) {
					sprite = Sprite.DERECHA2;
				} else {
					sprite = Sprite.DERECHA0;
				}
			}
		}

		// perderVida();

		if ((x >= 170 && x <= 265) && y <= 105) {
			Manager.InicioJuego();

		}

	}

	public int obtenerVida() {
		return getVidaActual();
	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}

	public void perderVida() {

	}

//	@Override
//	public void eliminar() {
//
//		if (getVidaMax() == 0) {
//			System.exit(0);
//		}
//	}
}

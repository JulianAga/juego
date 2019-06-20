package entes.criaturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

//ACA IRIAN LOS IMPORTS DEL JSON

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import habilidades.Habilidad;
import herramientas.CalcularStats;
import herramientas.Dado;
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

	private int expBase;

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
	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY, Integer vidaMax,
			Integer defensa, Integer resistenciaM, Integer dañoF, Integer dañoM, Integer velocidad, Integer level,
			String clase, Integer ExpBase) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;

		statsI = new HashMap<>();
		statsI.put(this.vidaMax, Dado.tirarDado(31));
		statsI.put(this.resistenciaF, Dado.tirarDado(31));
		statsI.put(this.resistenciaM, Dado.tirarDado(31));
		statsI.put(this.dañoF, Dado.tirarDado(31));
		statsI.put(this.dañoM, Dado.tirarDado(31));
		statsI.put(this.velocidad, Dado.tirarDado(31));

		this.clase = clase;

		stats = new LinkedHashMap<>();

		vidaMax = CalcularStats.calcularHp(vidaMax, vidaMax, level);
		stats.put(this.vidaActual, stats.get(this.vidaMax));
		stats.put(this.dañoF, CalcularStats.calcularStat(dañoF, statsI.get(this.dañoF), level));
		stats.put(this.dañoM, CalcularStats.calcularStat(dañoM, statsI.get(this.dañoM), level));
		stats.put(this.resistenciaF, CalcularStats.calcularStat(defensa, statsI.get(this.resistenciaF), level));
		stats.put(this.resistenciaM, CalcularStats.calcularStat(resistenciaM, statsI.get(this.resistenciaM), level));
		stats.put(this.velocidad, CalcularStats.calcularStat(velocidad, statsI.get(this.velocidad), level));
		stats.put(this.exp, CalcularStats.setearExp(level));
		stats.put(this.nivel, level);

		habilidades = new ArrayList<Habilidad>();
		conVida = true;

	}

	protected static Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
		statsI = new HashMap<>();
		stats = new LinkedHashMap<>();
		habilidades = new ArrayList<Habilidad>();
	}

//	public void RecuperarSalud() {
//		setVidaActual(getVidaMax());
//	}

	public boolean conVida() {
		return conVida;
	}

//	public void mostrarStatsPersonaje()
//	{
//		InteraccionUsuario.MostrarStatsPersonaje(stats);
//	}
//	
//	public void mostrarVida()
//	{
//		InteraccionUsuario.MostrarVida(getVidaMax(),getVidaActual());
//	}
//	

	/**
	 * Resta la cantidad de vida que se pasa por parámetro.
	 */
	public void QuitarVida(int resta) {
		int vida = stats.get(vidaActual);
		vida -= resta;
		stats.put(vidaActual, vida);
	}

	protected void setHabilidades(ArrayList<Habilidad> h) {
		habilidades = h;
	}

//	public void mostrarHabilidades()
//	{
//		InteraccionUsuario.MostrarHabilidades(this);
//	}

	// Getters y Setters

	public int getResistenciaM() {
		return stats.get(resistenciaM);
	}

	public int getVelocidad() {
		return stats.get(velocidad);
	}

	@Override
	public int getVidaActual() {
		return stats.get(vidaActual);
	}

	public String getVidaMax() {
		return vidaMax;
	}

	public int getResistenciaF() {
		return stats.get(resistenciaF);
	}

	public int getDañoF() {
		return stats.get(dañoF);
	}

	public int getDañoM() {
		return stats.get(dañoM);
	}

	public int getExp() {
		return stats.get(exp);
	}

	public Habilidad getHabilidad(int index) {
		return habilidades.get(index);
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

//	@Override
//	public int getExpBase() {
//		return expBase;
//	}
//
//	public void setExpBase(int expBase) {
//		this.expBase = expBase;
//	}

	public void setVidaActual(int vida) {
		stats.put(vidaActual, vida);
	}

//	public void setVidaMax(Integer vidaMax) {
//		stats.put(vidaMax, vidaMax);
//	}

	public void setResistenciaF(int defensa) {
		stats.put(this.resistenciaF, defensa);
	}

	public void setResistenciaM(int recistenciaM) {
		stats.put(this.resistenciaM, recistenciaM);
	}

	public void setDañoF(int dañoF) {
		stats.put(this.dañoF, dañoF);
	}

	public void setDañoM(int dañoM) {
		stats.put(this.dañoM, dañoM);
	}

	public void setExp(int exp) {
		stats.put(this.exp, stats.get(this.exp) + exp);
	}

	public void setNivel(int level) {
		stats.put(this.nivel, level);
	}

	public void setVelocidad(int velocidad) {
		stats.put(this.velocidad, velocidad);
	}

	public String getVidaActualString() {
		return vidaActual;
	}

	public String getVidaMaxString() {
		return this.vidaMax;
	}

	public String getResistenciaFString() {
		return this.resistenciaF;
	}

	public String getResistenciaMString() {
		return this.resistenciaM;
	}

	public String getDañoFString() {
		return this.dañoF;
	}

	public String getDañoMString() {
		return this.dañoM;
	}

	public String getVelocidadString() {
		return this.velocidad;
	}

	public String getExpString() {
		return this.exp;
	}

	public String getNivelString() {
		return this.nivel;
	}

	public LinkedHashMap<String, Integer> getStatsMap() {
		return stats;
	}

	/*
	 * no anda esta wea public JSONObject getFormatoJSON() throws JSONException {
	 * JSONObject a = new JSONObject(); a.put("Stats", stats); a.put("StatsI",
	 * statsI); a.put("Habilidades", habilidades); a.put("Con Vida", conVida);
	 * a.put("Ubicacion", ubicacion); return a; }
	 */

//	public int getNivel() {
//		return stats.get(nivel);
//	}

	@Override
	public void actualizar() {

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
					sprite = sprite.ARRIBA0;
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
					sprite = sprite.ABAJO0;
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
					sprite = sprite.IZQUIERDA0;
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
					sprite = sprite.DERECHA0;
				}
			}
		}

		// perderVida();

		if ((x >= 170 && x <= 265) && y <= 105) {
			pelea.InicioJuego();
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

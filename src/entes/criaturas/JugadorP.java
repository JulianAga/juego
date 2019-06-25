package entes.criaturas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import combate.Inventario;
import habilidades.Habilidad;
import herramientas.CalcularStats;
import herramientas.Dado;
import manager.InteraccionUsuario;

public class JugadorP implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Estas variables representan las estad�sticas individuales que pueden tener
	 * los personajes. Son numeros al azar entre 1 y 31 y sirven, en conjunto con
	 * las estad�sticas base de la clase, para calcular las estad�sticas finales del
	 * personaje tanto cuando es creado como cuando sube de nivel.
	 */
	private HashMap<String, Integer> statsI;

	/**
	 * Son las estad�sticas finales y visibles que posee un personaje una vez se lo
	 * calcula en referencia a las estad�sticas individuales (del personaje) y base
	 * (de la clase).
	 */
	private LinkedHashMap<String, Integer> stats;

	// Las claves utilizadas en los HashMap
	private final String vidaActual = "Vida actual";
	private final String vidaMax = "Vida max";
	private final String resistenciaF = "Resistencia f";
	private final String resistenciaM = "Resistencia m";
	private final String da�oF = "Da�o f";
	private final String da�oM = "Da�o m";
	private final String velocidad = "Velocidad";
	private final String exp = "Exp";
	private final String nivel = "Nivel";

	private ArrayList<Habilidad> habilidades;

	private Inventario<Object> inventario;

	private boolean conVida;

	private String ubicacion;

	private int expBase;

	private String clase;
	/*
	 * private int vidaActual; private int vidaMax; private int defensa; private int
	 * recistencia; private int da�oF; private int da�oM; private int exp; private
	 * int level;
	 */

	public String getClase() {
		return clase;
	}

	/**
	 * Crea una instancia de jugador vac�a.
	 */
	public JugadorP() {
		statsI = new HashMap<>();
		stats = new LinkedHashMap<>();
		habilidades = new ArrayList<Habilidad>();
	}

	/**
	 * Crea una instancia de la clase Jugador (pelea) con todos sus atributos
	 * pasados por par�metro.
	 */
	public JugadorP(Integer vidaMax, Integer defensa, Integer resistenciaM, Integer da�oF, Integer da�oM,
			Integer velocidad, Integer level, String clase, Integer ExpBase) {

		statsI = new HashMap<>();
		statsI.put(this.vidaMax, Dado.tirarDado(31));
		statsI.put(this.resistenciaF, Dado.tirarDado(31));
		statsI.put(this.resistenciaM, Dado.tirarDado(31));
		statsI.put(this.da�oF, Dado.tirarDado(31));
		statsI.put(this.da�oM, Dado.tirarDado(31));
		statsI.put(this.velocidad, Dado.tirarDado(31));

		this.clase = clase;

		stats = new LinkedHashMap<>();

		stats.put(this.vidaMax, CalcularStats.calcularHp(vidaMax, statsI.get(this.vidaMax), level));
		stats.put(this.vidaActual, stats.get(this.vidaMax));
		stats.put(this.da�oF, CalcularStats.calcularStat(da�oF, statsI.get(this.da�oF), level));
		stats.put(this.da�oM, CalcularStats.calcularStat(da�oM, statsI.get(this.da�oM), level));
		stats.put(this.resistenciaF, CalcularStats.calcularStat(defensa, statsI.get(this.resistenciaF), level));
		stats.put(this.resistenciaM, CalcularStats.calcularStat(resistenciaM, statsI.get(this.resistenciaM), level));
		stats.put(this.velocidad, CalcularStats.calcularStat(velocidad, statsI.get(this.velocidad), level));
		stats.put(this.exp, CalcularStats.setearExp(level));
		stats.put(this.nivel, level);

		habilidades = new ArrayList<Habilidad>();
		conVida = true;

		inventario = new Inventario<Object>();

	}

	/**
	 * Recupera toda la vida perdida del personaje hasta llenarla por completo.
	 */

	public Inventario obtenerInventario() {
		return inventario;
	}

	public void RecuperarSalud() {
		setVidaActual(getVidaMax());
	}

	public void Muerte() // iiiiaaaaaaaooooo
	{
		conVida = false;
	}

	public boolean conVida() {
		return conVida;
	}

	public void mostrarStatsPersonaje() {
		InteraccionUsuario.MostrarStatsPersonaje(stats);
	}

//	public void mostrarVida() {
//		InteraccionUsuario.MostrarVida(getVidaMax());
//	}

	/**
	 * Resta la cantidad de vida que se pasa por par�metro.
	 */
	public void QuitarVida(int resta) {
		int vida = stats.get(vidaActual);
		vida -= resta;
		stats.put(vidaActual, vida);
	}

	protected void setHabilidades(ArrayList<Habilidad> h) {
		habilidades = h;
	}

	public void mostrarHabilidades() {
		InteraccionUsuario.MostrarHabilidades(this);
	}

	// GETTERS Y SETTERS

	public int getResistenciaM() {
		return stats.get(resistenciaM);
	}

	public int getVelocidad() {
		return stats.get(velocidad);
	}

	public int getVidaActual() {
		return stats.get(vidaActual);
	}

	public int getVidaMax() {
		return stats.get(vidaMax);
	}

	public int getResistenciaF() {
		return stats.get(resistenciaF);
	}

	public int getDa�oF() {
		return stats.get(da�oF);
	}

	public int getDa�oM() {
		return stats.get(da�oM);
	}

	public int getExp() {
		return stats.get(exp);
	}

	public int getNivel() {
		return stats.get(nivel);
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

	public int getExpBase() {
		return expBase;
	}

	public void setExpBase(int expBase) {
		this.expBase = expBase;
	}

	public void setVidaActual(int vida) {
		stats.put(vidaActual, vida);
	}

	public void setVidaMax(int vidaMax) {
		stats.put(this.vidaMax, vidaMax);
	}

	public void setResistenciaF(int defensa) {
		stats.put(this.resistenciaF, defensa);
	}

	public void setResistenciaM(int recistenciaM) {
		stats.put(this.resistenciaM, recistenciaM);
	}

	public void setDa�oF(int da�oF) {
		stats.put(this.da�oF, da�oF);
	}

	public void setDa�oM(int da�oM) {
		stats.put(this.da�oM, da�oM);
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
		return this.vidaActual;
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

	public String getDa�oFString() {
		return this.da�oF;
	}

	public String getDa�oMString() {
		return this.da�oM;
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

	public JSONObject getFormatoJSON() throws JSONException {
		JSONObject a = new JSONObject();
		a.put("Vida actual", this.getVidaActual());
		a.put("Vida max", this.getVidaMax());
		a.put("Resistencia fisica", this.getResistenciaF());
		a.put("Resistencia magica", this.getResistenciaM());
		a.put("Da�o fisico", this.getDa�oF());
		a.put("Da�o magico", this.getDa�oM());
		a.put("Velocidad", this.getVelocidad());
		a.put("Experiencia", this.getExp());
		a.put("Nivel", this.getNivel());
		a.put("Con Vida", this.conVida());
		a.put("Ubicacion", this.getUbicacion());
		return a;
	}

	public JSONObject getFormatoJSONInventario(int i) throws JSONException {
		JSONObject a = new JSONObject();
		a.put("Inventario", this.obtenerInventario().elegirObjeto(i).getClass().getSimpleName());
		return a;
	}

	public JSONArray getFormatoJSONArray() throws JSONException {
		JSONArray arr = new JSONArray();
		arr.put(this.getFormatoJSON());
		int i;
		for (i = 0; i < obtenerInventario().cantidadObjetos(); i++) {
			arr.put(this.getFormatoJSONInventario(i));
			i++;
		}
		return arr;
	}

	public static void grabar(JSONArray array) {
		try {
			FileWriter file = new FileWriter("statsinventario.json");
			file.write(array.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leer() {
		String contenido = "";
		try {
			contenido = new String(Files.readAllBytes(Paths.get("test1.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido;
	}

}

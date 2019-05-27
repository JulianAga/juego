package mapa;

import graficos.Pantalla;

public abstract class Mapa {
	private int ancho;
	private int alto;

	private int[] tiles;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		tiles = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarMapa(ruta);
	}

	private void generarMapa() {

	}

	private void cargarMapa(String ruta) {

	}

	public void mostrar(int compesacionX, int compensacionY, Pantalla pantalla) {

	}
}

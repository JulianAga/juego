package mapa;

import graficos.Pantalla;
import mapa.tile.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;

	protected int[] tiles;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		tiles = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarMapa(ruta);
	}

	protected void generarMapa() {

	}

	private void cargarMapa(String ruta) {

	}

	public void actualizar() {

	}

	public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) { //

		int o = compensacionX / 25; // la parte mas a la izquierda de la pantalla
		int e = (compensacionX + pantalla.obtenAncho()) / 25; // la parte mas a la derecha de la pantalla
		int n = compensacionY / 25; // la parte mas abajo de la pantalla
		int s = (compensacionY + pantalla.obtenAlto()) / 25; // la parte mas arriba de la pantalla

		for (int y = n; y < s; y++) {

			for (int x = o; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla); // muestra el tipo de tile/cuadro

			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		switch (tiles[x + y * ancho]) {
		case 0:
			return Cuadro.GENERICO;

		default:
			return Cuadro.VACIO;
		}
	}

}

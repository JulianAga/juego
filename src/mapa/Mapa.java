package mapa;

import graficos.Pantalla;
import mapa.tile.Cuadro;

public abstract class Mapa {
	protected int ancho;
	protected int alto;

	protected int[] cuadros;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		cuadros = new int[ancho * alto];
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

		pantalla.estableceDiferencia(compensacionX, compensacionY);

		int o = compensacionX >> 5; // la parte mas a la izquierda de la pantalla
		int e = (compensacionX + pantalla.obtenAncho()) >> 5; // la parte mas a la derecha de la pantalla
		int n = compensacionY >> 5; // la parte mas abajo de la pantalla
		int s = (compensacionY + pantalla.obtenAlto()) >> 5; // la parte mas arriba de la pantalla /BITSHIFTING >> 5 ES
																// LO MISMO QUE DIVIDIR POR 32

		for (int y = n; y < s; y++) {

			for (int x = o; x < e; x++) {
				obtenCuadro(x, y).mostrar(x, y, pantalla); // muestra el tipo de tile/cuadro

			}
		}
	}

	public Cuadro obtenCuadro(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= ancho) {
			return Cuadro.VACIO;
		}
		switch (cuadros[x + y * ancho]) {
		case 1:
			return Cuadro.ASFALTO;
		case 2:
			return Cuadro.ARENA;
		case 3:
			return Cuadro.BORDE_CARRETERA;

		default:
			return Cuadro.VACIO;
		}
	}

}

package graficos;

import mapa.tile.Cuadro;

public final class Pantalla {
	private final int ancho;
	private final int alto;

	private int diferenciaX;
	private int diferenciaY;

	public final int[] pixeles;

//	// temporal
//
//	private final static int LADO_SPRITE = 25;
//	private final static int MASCARA_SPRITE = LADO_SPRITE - 1;
//
//	// fin temporal

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];
	}

	public void limpiar() {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = 0;
		}
	}

//	// temporal
//	public void mostrar(final int compensacionX, final int compensacionY) {
//		for (int y = 0; y < alto; y++) {
//			int posicionY = y + compensacionY;
//			if (posicionY < 0 || posicionY >= alto) {
//				continue;
//			}
//
//			for (int x = 0; x < ancho; x++) {
//				int posicionX = x + compensacionX;
//
//				if (posicionX < 0 || posicionX >= ancho) {
//					continue;
//				}
//
//				// codigo para redibujar pantalla
//
//				pixeles[posicionX + posicionY * ancho] = Sprite.GENERICO.pixeles[(x
//						& MASCARA_SPRITE + (y & MASCARA_SPRITE) * LADO_SPRITE)];
//
//			}
//		}
//	}
//	// Fin temporal

	public void mostrarCuadro(int compensacionX, int compensacionY, Cuadro cuadro) { // va dibujando los sprites en la
																						// pantalla
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < cuadro.sprite.obtenLado(); y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < cuadro.sprite.obtenLado(); x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -cuadro.sprite.obtenLado() || posicionX >= ancho - cuadro.sprite.obtenLado()
						|| posicionY < cuadro.sprite.obtenLado() || posicionY >= alto - cuadro.sprite.obtenLado()) { // limita
																														// el
																														// dibujo
																														// de
																														// cuadros
					// al tamaño de la pantalla
					break;
				}
				if (posicionX < 0) {
					posicionX = 0;
				}
				pixeles[posicionX + posicionY * ancho] = cuadro.sprite.pixeles[x + y * cuadro.sprite.obtenLado()]; // pasa
																													// el
																													// cuadro
																													// a
																													// la
																													// posicion
																													// de
																													// la
																													// pantalla

			}
		}
	}

	public void estableceDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}

	public int obtenAncho() {
		return ancho;
	}

	public int obtenAlto() {
		return alto;
	}
}

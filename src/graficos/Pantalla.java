package graficos;

import entes.criaturas.Enemigo;
import entes.criaturas.Jugador;
import mapa.tile.Cuadro;

public final class Pantalla {
	private final int ancho;
	private final int alto;

	private int diferenciaX;
	private int diferenciaY;

	public final int[] pixeles;

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

	public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < jugador.obtenSprite().obtenLado(); y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < jugador.obtenSprite().obtenLado(); x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -jugador.obtenSprite().obtenLado() || posicionX >= ancho || posicionY < 0
						|| posicionY >= alto) {
					break;
				}
				if (posicionX < 0) {
					posicionX = 0;
				}
				// pixeles[posicionX + posicionY * ancho] =
				// jugador.obtenSprite().pixeles[x + y
				// * jugador.obtenSprite().obtenLado()];
				int colorPixelJugador = jugador.obtenSprite().pixeles[x + y * jugador.obtenSprite().obtenLado()];
				if (colorPixelJugador != 0xffffffff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelJugador;
				}
			}
		}
	}
	
	public void mostrarEnemigo(int compensacionX, int compensacionY, Enemigo enemigo) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < enemigo.obtenSprite().obtenLado(); y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < enemigo.obtenSprite().obtenLado(); x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -enemigo.obtenSprite().obtenLado() || posicionX >= ancho || posicionY < 0
						|| posicionY >= alto) {
					break;
				}
				if (posicionX < 0) {
					posicionX = 0;
				}
				// pixeles[posicionX + posicionY * ancho] =
				// jugador.obtenSprite().pixeles[x + y
				// * jugador.obtenSprite().obtenLado()];
				int colorPixelJugador = enemigo.obtenSprite().pixeles[x + y * enemigo.obtenSprite().obtenLado()];
				if (colorPixelJugador != 0xffffffff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelJugador;
					}
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

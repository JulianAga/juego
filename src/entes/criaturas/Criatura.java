package entes.criaturas;

import entes.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {
	protected Sprite sprite;
	protected char direccion = 'n';
	protected boolean enMovimiento = false;
	public int vida;

	public void establecerVida(int vida) {
		this.vida = vida;
	}

	@Override
	public void actualizar() {
	}

	@Override
	public void mostrar() {
	}

	public void mover(int desplazamientoX, int desplazamientoY) {
		if (desplazamientoX > 0) {
			direccion = 'e';
		}
		if (desplazamientoX < 0) {
			direccion = 'o';
		}
		if (desplazamientoY > 0) {
			direccion = 's';
		}
		if (desplazamientoY < 0) {
			direccion = 'n';
		}
//		System.out.println(mapa.obtenerAncho() * sprite.obtenLado());
		if (!estaEliminado()) {
			if (!enColision(desplazamientoX, 0)) {// verifica que el sprite no sea SOLIDO
				if (x + desplazamientoX > (mapa.obtenerAncho() * sprite.obtenLado()) - 26 || x + desplazamientoX < -6) {// verifica
																														// que
																														// no
																														// te
																														// salgas
																														// del
																														// mapa
																														// horizontalmente
					modificarPosicionX(0);
				} else {
					modificarPosicionX(desplazamientoX);
				}
			}
			if (!enColision(0, desplazamientoY)) {// verifica que el sprite no sea SOLIDO
				if (y + desplazamientoY > (mapa.obtenerAlto() * sprite.obtenLado()) - 35 || y + desplazamientoY < 0) {// verifica
																														// que
																														// no
																														// te
																														// salgas
																														// del
																														// mapa
																														// verticalmente

					modificarPosicionY(0);
				} else {
					modificarPosicionY(desplazamientoY);
				}
			}
		}
	}

	private boolean enColision(int desplazamientoX, int desplazamientoY) {

		boolean colision = false;

		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;

		int margenIzquierdo = -6;
		int margenDerecho = 18;

		int margenSuperior = -4;
		int margenInferior = 31;

		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.obtenLado();
		int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.obtenLado();
		int bordeSuperior = (posicionY + margenInferior) / sprite.obtenLado();
		int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.obtenLado();

		if (mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenerCuadroCatalogo(bordeIzquierdo + bordeInferior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenerCuadroCatalogo(bordeDerecho + bordeSuperior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}
		if (mapa.obtenerCuadroCatalogo(bordeDerecho + bordeInferior * mapa.obtenerAncho()).esSolido()) {
			colision = true;
		}

		return colision;
	}

	public Sprite obtenSprite() {
		return sprite;
	}
}

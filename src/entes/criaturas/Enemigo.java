package entes.criaturas;

import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Enemigo extends Criatura {

	int animacion;

	public Enemigo(Mapa mapa, Sprite sprite) {
		this.mapa = mapa;
		this.sprite = sprite;
	}

	public Enemigo(Mapa mapa, Sprite sprite, int posicionX, int posicionY) {
		this.mapa = mapa;
		this.sprite = sprite;

		this.x = posicionX;
		this.y = posicionY;
	}

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

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		int resto = animacion % 40;

		if (direccion == 'n') {
			sprite = Sprite.STANDING;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.STANDING;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.STANDING;
				} else if (resto > 30) {
					sprite = Sprite.STANDING;
				} else {
					sprite = sprite.STANDING;
				}
			}
		}
		if (direccion == 's') {
			sprite = Sprite.STANDING;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.STANDING;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.STANDING;
				} else if (resto > 30) {
					sprite = Sprite.STANDING;
				} else {
					sprite = sprite.STANDING;
				}
			}
		}
		if (direccion == 'o') {
			sprite = Sprite.STANDING;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.STANDING;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.STANDING;
				} else if (resto > 30) {
					sprite = Sprite.STANDING;
				} else {
					sprite = sprite.STANDING;
				}
			}
		}
		if (direccion == 'e') {
			sprite = Sprite.STANDING;
			if (enMovimiento) {
			} else if (resto > 20 && resto <= 30) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.STANDING;
					sprite = Sprite.STANDING;
				} else if (resto > 30) {
					sprite = Sprite.STANDING;
				} else {
					sprite = sprite.STANDING;
				}
			}
		}

	}

	public void mostrar(Pantalla pantalla) {

		pantalla.mostrarEnemigo(x, y, this);
	}

}

package entes.criaturas;

import entes.Ente;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Enemigo extends Criatura {

	int animacion;

	public Enemigo(Mapa mapa, Sprite sprite) {
		Ente.mapa = mapa;
		this.sprite = sprite;
	}

	public Enemigo(Mapa mapa, Sprite sprite, int posicionX, int posicionY) {
		Ente.mapa = mapa;
		this.sprite = sprite;

		this.x = posicionX;
		this.y = posicionY;
	}

	@Override
	public void actualizar() {

		int desplazamientoX = 0;
		int desplazamientoY = 0;

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
//		int i=0;
//		do
//		{
//			desplazamientoX=1;
//			i++;	
//		}
//		while(i<123);
//		
//		desplazamientoX=0;
		sprite = Sprite.STANDING;

	}

	public void mostrar(Pantalla pantalla) {

		pantalla.mostrarEnemigo(x, y, this);
	}

}

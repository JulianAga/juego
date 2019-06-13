package entes.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Enemigo extends Criatura {

	public Enemigo(Mapa mapa, Sprite sprite) {
		this.mapa = mapa;
		this.sprite = sprite;
	}
	
	public Enemigo (Mapa mapa, Sprite sprite, int posicionX, int posicionY) {
		this.mapa = mapa;
		this.sprite = sprite;
		this.x = posicionX;
		this.y = posicionY;
		establecerVida(100);
	}
	
	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarEnemigo(x, y, this);
	}


}

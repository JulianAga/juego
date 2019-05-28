package mapa.tile;

import graficos.Pantalla;
import graficos.Sprite;

public abstract class Cuadro {
	public int x;
	public int y;

	public Sprite sprite;

	// Coleccion de cuadros
	public static final Cuadro VACIO = new CuadroVacio(Sprite.VACIO);
	public static final Cuadro GENERICO = new CuadroGenerico(Sprite.GENERICO);
	// Fin coleccion de cuadros

	public Cuadro(Sprite sprite) {
		this.sprite = sprite;
	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarCuadro(x * 25, y * 25, this);
	}

	public boolean solido() {
		return false;
	}
}

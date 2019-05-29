package mapa;

import java.util.Random;

public class MapaGenerado extends Mapa {

	private static final Random aleatorio = new Random();

	public MapaGenerado(int ancho, int alto) {
		super(ancho, alto);
	}

	@Override
	protected void generarMapa() { // lanza un numero aleatorio y eso determina que tipo de sprite será
		for (int y = 0; y < alto; y++) {
			for (int x = 0; x < ancho; x++) {
				cuadros[x + y * ancho] = aleatorio.nextInt(3);// cantidad de distintos sprites a generar
			}
		}
	}
}

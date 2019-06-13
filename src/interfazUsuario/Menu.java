package interfazUsuario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import entes.criaturas.Jugador;
import herramientas.DibujoDebug;

public class Menu {

	private Rectangle areaInv;
	private Rectangle borde;

	private Color color;

	public Menu(final Jugador jugador) {
		int altoMenu = 64;
		areaInv = new Rectangle(0, 800, 600, altoMenu);
		borde = new Rectangle(areaInv.x, areaInv.y - 1, areaInv.width, 1);

		color = new Color(23, 23, 23);
	}

	public void dibujar(final Graphics g, final Jugador jugador) {
		dibujarAreaInventario(g);
	}

	private void dibujarAreaInventario(final Graphics g) {
		DibujoDebug.dibujarRectanguloRelleno(g, areaInv, Color.white);
	}

}

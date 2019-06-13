package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import entes.criaturas.Enemigo;
import entes.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static volatile boolean enFuncionamiento = false;

	private static final String NOMBRE = "ROL";
	private static String CONTADOR_APS = "";
	private static String CONTADOR_FPS = "";

	private static int fps = 0;
	private static int aps = 0;

	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;

	private static Mapa mapa;
	private static Jugador jugador;
	private static Enemigo enemigo;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData(); // Contamos los
																									// pixeles

	public static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/Velez.png")); // con esta
																										// funcion
																										// añadimos el
																										// icono
//

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);

		// mapa = new MapaGenerado(128, 128);

		teclado = new Teclado();
		addKeyListener(teclado);

		mapa = new MapaCargado("/mapas/mapaDesierto.png");

		enemigo = new Enemigo(mapa, teclado, Sprite.STANDING, 123, 123);

		jugador = new Jugador(mapa, teclado, Sprite.ARRIBA0, 225, 225);

		//
		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setIconImage(icono.getImage());
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.setUndecorated(true);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();

	}

	private synchronized void iniciar() {
		enFuncionamiento = true;

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detener() {
		enFuncionamiento = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void actualizar() {
		teclado.actualizar();

		jugador.actualizar();

		enemigo.actualizar();

		if (teclado.salir) {
			System.exit(0);
		}

		aps++;
	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		// pantalla.limpiar();
		mapa.mostrar(jugador.obtenerPosicionX() - pantalla.obtenAncho() / 2 + jugador.obtenSprite().obtenLado() / 2,
				jugador.obtenerPosicionY() - pantalla.obtenAlto() / 2 + jugador.obtenSprite().obtenLado() / 2,
				pantalla);
		jugador.mostrar(pantalla);
		enemigo.mostrar(pantalla);

		System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

		// for (int i = 0; i < pixeles.length; i++) {
		// pixeles[i] = pantalla.pixeles[i];
		// }
//		Graphics g = estrategia.getDrawGraphics();

		Graphics2D g = (Graphics2D) estrategia.getDrawGraphics();

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.red);

		g.drawString(CONTADOR_APS, 10, 20);
		g.drawString(CONTADOR_FPS, 10, 35);
		g.drawString("X. " + jugador.obtenerPosicionX(), 10, 50);
		g.drawString("Y. " + jugador.obtenerPosicionY(), 10, 65);
		g.drawString("Vida. " + jugador.obtenerVida(), 10, 75);
		g.dispose();

		estrategia.show();

		fps++;
	}

	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000; // nanosegundos en un segundo
		final byte APS_OBJETIVO = 60; // actualizaciones que queremos por segundo
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO; // actualizar 60 por segundo

		long referenciaActualizacion = System.nanoTime(); //
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0; // cantidad de tiempo transcurrido hasta actualizacion

		requestFocus(); // autoenfocar el teclado en la ventana

		while (enFuncionamiento) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion; // medimos cuanto paso entre el inicio del bucle
																		// y el fin
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) // actualiza el juego cuando delta es uno
			{
				actualizar();
				delta--;
			}

			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				CONTADOR_APS = "APS : " + aps;
				CONTADOR_FPS = "FPS : " + fps;

				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}

package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	private final int ancho;
	private final int alto;
	public final int[] pixeles;

	// coleccion de hojas de sprites
	public static HojaSprites ejemplo = new HojaSprites("/texturas/SpritePrueba.png", 320, 320); // CARGAR LA IMAGEN
	public static HojaSprites jugador = new HojaSprites("/texturas/jugador.png", 128, 96);
	public static HojaSprites enemigo = new HojaSprites("/texturas/Gonza.png", 128, 96);

	// fin de la coleccion

	/**
	 * Define la ruta de la hoja de sprites
	 * 
	 * @param ruta  Directorio en el que se encuentra
	 * @param ancho ancho del documento
	 * @param alto  alto del documento
	 */
	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];

		BufferedImage imagen;
		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(ruta));

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int obtenerAncho() {
		return ancho;
	}

}

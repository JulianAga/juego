package graficos;

public final class Sprite {

	private final int lado;

	private int x;
	private int y;

	public int[] pixeles;
	private HojaSprites hoja;

	// coleccion de sprites
	public static final Sprite VACIO = new Sprite(32, 0);
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.ejemplo);
	public static final Sprite ARENA = new Sprite(32, 1, 0, HojaSprites.ejemplo);
	public static final Sprite BORDE_CARRETERA_IZQUIERDO = new Sprite(32, 2, 0, HojaSprites.ejemplo);
	public static final Sprite BORDE_CARRETERA_DERECHO = new Sprite(32, 2, 0, HojaSprites.ejemplo);
	public static final Sprite BORDE_CARRETERA_INFERIOR = new Sprite(32, 2, 0, HojaSprites.ejemplo);
	public static final Sprite BORDE_CARRETERA_SUPERIOR = new Sprite(32, 2, 0, HojaSprites.ejemplo);
	public static final Sprite CENTRO_CARRETERA_VERTICAL = new Sprite(32, 3, 0, HojaSprites.ejemplo);
	public static final Sprite CENTRO_CARRETERA_HORIZONTAL = new Sprite(32, 3, 0, HojaSprites.ejemplo);
	public static final Sprite ESQUINA_CARRETERA_INFERIOR_IZQUIERDA = new Sprite(32, 4, 0, HojaSprites.ejemplo);
	public static final Sprite ESQUINA_CARRETERA_INFERIOR_DERECHA = new Sprite(32, 4, 0, HojaSprites.ejemplo);
	public static final Sprite ESQUINA_CARRETERA_SUPERIOR_IZQUIERDA = new Sprite(32, 4, 0, HojaSprites.ejemplo);
	public static final Sprite ESQUINA_CARRETERA_SUPERIOR_DERECHA = new Sprite(32, 4, 0, HojaSprites.ejemplo);
	public static final Sprite PARED_PIEDRA = new Sprite(32, 5, 0, HojaSprites.ejemplo);
	public static final Sprite PARED_PIEDRA_INFERIOR = new Sprite(32, 6, 0, HojaSprites.ejemplo);
	public static final Sprite PARED_PIEDRA_CARRETERA = new Sprite(32, 0, 3, HojaSprites.ejemplo);
	public static final Sprite PARED_PIEDRA_CARRETERA_X_INVERTIDO = new Sprite(32, 0, 3, HojaSprites.ejemplo);
	public static final Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32, 7, 0, HojaSprites.ejemplo);
	public static final Sprite PUERTA_SUPERIOR_DERECHA = new Sprite(32, 7, 0, HojaSprites.ejemplo);
	public static final Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32, 7, 1, HojaSprites.ejemplo);
	public static final Sprite PUERTA_INTERMEDIA_DERECHA = new Sprite(32, 7, 1, HojaSprites.ejemplo);
	public static final Sprite PUERTA_INFERIOR = new Sprite(32, 8, 1, HojaSprites.ejemplo);
	public static final Sprite OXIDO = new Sprite(32, 9, 0, HojaSprites.ejemplo);
	public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0, HojaSprites.ejemplo);
	// fin de la coleccion

	public Sprite(final int lado, final int columna, final int fila, final int modo, final HojaSprites hoja) {
		this.lado = lado;

		pixeles = new int[lado * lado];

		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;

		cargarSprite(modo);

	}

	public Sprite(final int lado, final int color) {
		this.lado = lado;
		pixeles = new int[lado * lado];

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}

	public int obtenLado() {
		return lado;
	}

	private void cargarSprite(int modo) {
		if (modo == 0) {
			cargaNormal();
		} else {
			cargaManipulada(modo);
		}
	}

	private void cargaNormal() {
		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenerAncho()];
			}
		}
	}

	private void cargaManipulada(int modo) {
		int[] pixelesTemporales = inicializarPixelesTemporales();

		switch (modo) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		}
	}

	private int[] inicializarPixelesTemporales() {
		int[] pixelesTemporales = new int[lado * lado];
		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenerAncho()];
			}
		}
		return pixelesTemporales;
	}
}

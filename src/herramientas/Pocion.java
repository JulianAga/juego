package herramientas;

public class Pocion {

	int vida;

	public Pocion() {
		vida = Dado.numeroAleatorio(10);
	}

	public int tomar() {
		return vida;
	}
}

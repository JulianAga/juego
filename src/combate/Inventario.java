package combate;

import java.util.ArrayList;

public class Inventario<T> {

	private static final int LIMITE_INVENTARIO = 7;
	T obj;
	private ArrayList<T> objetos;

	public Inventario() {
		objetos = new ArrayList<T>();
	}

	public String obtenerObjeto(T o) {
		return o.toString();
	}

	public String almacenarEnInventario(T o) {
		String mensaje;
		if (objetos.size() < LIMITE_INVENTARIO) {
			objetos.add(o);
			mensaje = "objeto añadido exitosamente";
		} else {
			mensaje = "no puedes añadir mas de 7 objetos a tu inventario";
		}
		return mensaje;
	}

	public String removerDelInventario(int index) {
		String mensaje = null;

		if (objetos.isEmpty()) {
			mensaje = "no hay nada en el inventario";
		} else {
			objetos.remove(index);
		}

		return mensaje;
	}

}

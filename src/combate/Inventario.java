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

	public boolean estaVacio() {
		boolean flag = false;
		if (objetos.isEmpty()) {
			flag = true;
		}
		return flag;
	}

	public String removerDelInventario(int index) {
		String mensaje = "se cierra el inventario";

		if (objetos.isEmpty()) {
			mensaje = "no hay nada en el inventario";
		} else {
			objetos.remove(index);
		}

		return mensaje;
	}

	public int mostrarInventario() {
		int index = 0;
		for (T i : objetos) {
			System.out.println("Objeto numero " + index + " " + i.getClass().getSimpleName());
			index++;
		}
		return index;
	}

	public T elegirObjeto(int i) {
		return objetos.get(i);
	}

}

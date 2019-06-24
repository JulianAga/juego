package manager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import biblioteca.escenario.CaminoNorte;
import biblioteca.escenario.PuebloInicio;
import combate.Inventario;
import entes.criaturas.JugadorP;
import entes.criaturas.Ladron;
import entes.criaturas.Paladin;
import excepciones.OpcionInvalidoException;
import herramientas.Biblioteca;
import herramientas.CajaSorpresa;
import herramientas.Pocion;

/**
 * Esta clase es la encargada de poner a funcionar el juego.
 *
 */
public class Manager {

	public static void InicioJuego() throws OpcionInvalidoException {
		int comando = 0;
		boolean flag = false;
		JugadorP jugador = null;
		while (!flag) {
			InteraccionUsuario.InicioJuego();
			comando = InteraccionUsuario.ElegirOpcion(); 
			InteraccionUsuario.separador();
			switch (comando) {
			case 1: // Crear Ladron.
				jugador = new Ladron(1);
				jugador.setUbicacion(Biblioteca.Mapa_PuebloInicio());
				flag = true;
				Juego(jugador);
				break;
			case 2: // Crear Paladin.
				jugador = new Paladin(1);
				jugador.setUbicacion(Biblioteca.Mapa_PuebloInicio());
				flag = true;
				Juego(jugador);
				break;
			default:
				InteraccionUsuario.OpcionInvalida();
			break;
			}
		}
		JSONArray arr = new JSONArray();
		try {
			arr = jugador.getFormatoJSONArray();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jugador.grabar(arr);
	}

	public static void FinJuego() {

	}

	/**
	 * Comienza el juego evaluando la posición en la que se encuentra el jugador y
	 * continúa desde allí.
	 */
	public static void Juego(JugadorP jugador) {
		int opcion;
		PuebloInicio puebloInicio = new PuebloInicio();
		CaminoNorte caminoNorte = new CaminoNorte();
		Inventario inventario = new Inventario();
		while (jugador.conVida()) {
			InteraccionUsuario.MostrarClase(jugador.getClase());
			InteraccionUsuario.MostrarVida(jugador.getVidaMax(), jugador.getVidaActual());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getNivelString());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getExpString());
			InteraccionUsuario.espacio();
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_PuebloInicio())) {
				// PuebloInicio posada = new PuebloInicio();
				opcion = InteraccionUsuario.OpcionesPuebloInicio();

				switch (opcion) {
				case 1:
					puebloInicio.Posada(jugador);
					InteraccionUsuario.separador();
					break;
				case 2:
					puebloInicio.Avanzar(jugador);
					InteraccionUsuario.separador();
					break;
				case 3:
					puebloInicio.Retroceder(jugador);
					InteraccionUsuario.separador();
					break;
				default:
					InteraccionUsuario.OpcionInvalida();
					InteraccionUsuario.separador();
				}
			}
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_CaminoNorte())) {
				CaminoNorte caminoNorte2 = new CaminoNorte();
				opcion = InteraccionUsuario.OpcionesCamino(Biblioteca.Mapa_CaminoNorte());
				switch (opcion) {
				case 1:
					caminoNorte.Avanzar(jugador);
					InteraccionUsuario.separador();
					break;
				case 2:
					caminoNorte.Retroceder(jugador);
					InteraccionUsuario.separador();
					break;
				case 3:
					int limite = jugador.obtenerInventario().mostrarInventario();

					int opcionInventario;
					if (!jugador.obtenerInventario().estaVacio()) {
						do {
							opcionInventario = InteraccionUsuario.ElegirOpcion();
							if (opcionInventario >= limite || opcionInventario < 0) {
								System.out.println("Error, ingrese una opcion valida");
							}
						} while (opcionInventario >= limite || opcionInventario < 0);
						Object obj = jugador.obtenerInventario().elegirObjeto(opcionInventario);
						System.out.println(jugador.obtenerInventario().removerDelInventario(opcionInventario));
						if (obj instanceof Pocion) {
							((Pocion) obj).tomar(jugador);
						} else {
							((CajaSorpresa) obj).sorpresa(jugador);
						}
					} else {
						System.out.println("Inventario Vacio");
					}
					break;
				}
			}
		}
		System.out.println("Perdiste");
		System.out.close();
	}

}

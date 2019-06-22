package manager;

import org.json.JSONException;
import org.json.JSONObject;

import biblioteca.escenario.CaminoNorte;
import biblioteca.escenario.PuebloInicio;
import entes.criaturas.JugadorP;
import entes.criaturas.Ladron;
import entes.criaturas.Paladin;
import herramientas.Biblioteca;

/**
 * Esta clase es la encargada de poner a funcionar el juego.
 *
 */
public class Manager {

	public static void InicioJuego() {
		int comando;
		boolean flag = false;
		InteraccionUsuario.InicioJuego();
		comando = InteraccionUsuario.ElegirOpcion();
		JugadorP jugador = null;
		while (!flag) {
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
				flag = true;
				break;
			}
		}
		JSONObject stats = new JSONObject();
		try {
			stats = jugador.getFormatoJSON();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jugador.grabar(stats);
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
		while (jugador.conVida()) {
			InteraccionUsuario.MostrarVida(jugador.getVidaMax(), jugador.getVidaActual());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getNivelString());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getExpString());
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_PuebloInicio())) {
				// PuebloInicio posada = new PuebloInicio();
				opcion = InteraccionUsuario.OpcionesPuebloInicio();

				switch (opcion) {
				case 1:
					puebloInicio.Posada(jugador);
					break;
				case 2:
					puebloInicio.Avanzar(jugador);
					break;
				case 3:
					puebloInicio.Retroceder(jugador);
					break;
				default:
					InteraccionUsuario.OpcionInvalida();
				}
			}
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_CaminoNorte())) {
				CaminoNorte caminoNorte2 = new CaminoNorte();
				opcion = InteraccionUsuario.OpcionesCamino(Biblioteca.Mapa_CaminoNorte());
				switch (opcion) {
				case 1:
					caminoNorte.Avanzar(jugador);
					break;
				case 2:
					caminoNorte.Retroceder(jugador);
					break;
				}
			}
		}
		System.out.println("Perdiste");
	}

}

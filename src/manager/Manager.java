package manager;

import entes.criaturas.Jugador;
import entes.criaturas.Ladron;
import entes.criaturas.Paladin;
import herramientas.Biblioteca;

public class Manager {

	public static void InicioJuego() {
		int comando;
		boolean flag = false;
		InteraccionUsuario.InicioJuego();
		comando = InteraccionUsuario.ElegirOpcion();
		Jugador jugador;
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
	}

	public static void FinJuego() {

	}

	public static void Juego(Jugador jugador) // Comienza el juego evaluando la posición en la
	// que se encuentra el jugador y continua desde allí
	{
		int opcion;

		while (jugador.conVida()) {
			InteraccionUsuario.MostrarVida(jugador.getVidaMax(), jugador.getVidaActual());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getNivelString());
			InteraccionUsuario.MostrarClaveValor(jugador.getStatsMap(), jugador.getExpString());
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_PuebloInicio())) {
				opcion = InteraccionUsuario.OpcionesPuebloInicio();
				switch (opcion) {
				case 1:
//					puebloInicio.Posada(jugador);
					break;
				case 2:
//					puebloInicio.Avanzar(jugador);
					break;
				default:
					InteraccionUsuario.OpcionInvalida();
				}
			}
			if (jugador.getUbicacion().equals(Biblioteca.Mapa_CaminoNorte())) {
				opcion = InteraccionUsuario.OpcionesCamino(Biblioteca.Mapa_CaminoNorte());
				switch (opcion) {
				case 1:
//					caminoNorte.Avanzar(jugador);
					break;
				case 2:
//					caminoNorte.Retroceder(jugador);
					break;

				}
			}
		}
		System.out.println("Perdiste");
	}

}

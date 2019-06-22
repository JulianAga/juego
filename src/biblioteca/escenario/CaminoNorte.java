package biblioteca.escenario;

import combate.Inventario;
import combate.MetodosCombate;
import entes.criaturas.JugadorP;
import entes.criaturas.PerroSalvaje;
import herramientas.Biblioteca;
import herramientas.Dado;
import manager.InteraccionUsuario;

public class CaminoNorte extends Camino {

	public CaminoNorte() {
		dificultad = 2;
		ubicacion = 0;
	}

	Inventario<Object> inventario = new Inventario<Object>();

	public void Avanzar(JugadorP a) {
		if (ubicacion < 5) {
			flag = true;
			ubicacion++;
			InteraccionUsuario.AvanzasElCamino();
			numero = Dado.tirarDado(100);
			if (numero < 20) {
				p = new PerroSalvaje(Dado.tirarDado(dificultad));
				while (flag == true) {
					opcion = InteraccionUsuario.Encounter(p.getClase());
					if (opcion == 1) {
						// InteraccionUsuario.MostrarHabilidades(p);
						MetodosCombate.Combate(a, p);
						flag = false;
					} else if (opcion == 2) {
						numero = Dado.tirarDado(50);
						if (numero < 20) {
							InteraccionUsuario.NoPuedesEscapar();
							MetodosCombate.Combate(a, p);
							flag = false;
						} else {
							InteraccionUsuario.LograsEscapar();
							flag = false;
						}
					} else {
						InteraccionUsuario.OpcionInvalida();
					}
				}
			} else if (numero < 50 && numero > 20) {

				inventario.almacenarEnInventario(InteraccionUsuario.pocion());

			} else if (numero < 65 && numero > 50) {

				inventario.almacenarEnInventario(InteraccionUsuario.cajaSorpresa());
			}
			inventario.mostrarInventario();
		} else if (ubicacion >= 5) {
			while (!flag) {
				opcion = InteraccionUsuario.FinalCamino(Biblioteca.Mapa_PuebloSegundo());
				switch (opcion) {
				case 1:
					a.setUbicacion(Biblioteca.Mapa_PuebloSegundo());
					flag = true;
					break;
				case 2:
					this.Retroceder(a);
					flag = true;
					break;
				default:
					InteraccionUsuario.OpcionInvalida();
					break;
				}
			}
		}
	}

	public void Retroceder(JugadorP a) {
		if (ubicacion == 0) {
			opcion = InteraccionUsuario.FinalCamino(Biblioteca.Mapa_PuebloInicio());
			switch (opcion) {
			case 1:
				a.setUbicacion(Biblioteca.Mapa_PuebloInicio());
			}
		} else if (ubicacion > 0) {
			flag = true;
			ubicacion--;
			InteraccionUsuario.RetrocedesElCamino();
			numero = Dado.tirarDado(100);
			if (numero < 20) {
				p = new PerroSalvaje(Dado.tirarDado(dificultad));
				while (flag == true) {
					opcion = InteraccionUsuario.Encounter(p.getClase());
					if (opcion == 1) {
						MetodosCombate.Combate(a, p);
						flag = false;
					} else if (opcion == 2) {
						numero = Dado.tirarDado(50);
						if (numero < 20) {
							InteraccionUsuario.NoPuedesEscapar();
							MetodosCombate.Combate(a, p);
							flag = false;
						} else {
							InteraccionUsuario.LograsEscapar();
							flag = false;
						}
					} else {
						InteraccionUsuario.OpcionInvalida();
					}
				}
			}
		}
	}
}

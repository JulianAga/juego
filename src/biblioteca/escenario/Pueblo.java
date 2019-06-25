package biblioteca.escenario;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import entes.criaturas.JugadorP;
import manager.InteraccionUsuario;

public abstract class Pueblo {

	public void Posada(JugadorP a) {
		if (a.getVidaActual() == a.getVidaMax()) {
			InteraccionUsuario.YaEstasDescansado();
		} else {
			a.RecuperarSalud();
			InteraccionUsuario.TeRecuperastePleno();
		}

	}

	public abstract void Avanzar(JugadorP p);

	public abstract void Retroceder(JugadorP p);
	

	public static void GuardarPartida(JSONObject obj) 
	{
		try 
		{
			FileWriter file = new FileWriter("Personaje.json");
			file.write(obj.toString());
			file.flush();
			file.close();
			InteraccionUsuario.GuardadoExitoso();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
	
	/*
	public static String leer() {
		String contenido = "";
		try {
			contenido = new String(Files.readAllBytes(Paths.get("test1.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido;
	}*/
}

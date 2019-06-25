package entes.criaturas;

public interface AccionesPersonaje 
{
	public void RecuperarSalud();
	public void Muerte();
	public boolean conVida();
	public void mostrarStatsPersonaje();
	public void QuitarVida(int resta);
	public void mostrarHabilidades();
}
package habilidades;

public class Habilidad {

	private String nombre;
	private String tipoDaño; //Tipo de daño posible es F (fisico) o M (magico) (por ahora....)
	private int potencia;
	private int costoMana;
	private int nivelDesbloqueo;
	private int prioridad;
	
	public Habilidad() 
	{
		nombre = "";
		tipoDaño = "";
		potencia = 0;
		costoMana = 0;
	}
	
	public Habilidad(String nombre, String tipoDaño, int potencia, int costoMana, int nivelDesbloqueo,
			int prioridad) 
	{
		this.nombre = nombre;
		this.tipoDaño = tipoDaño;
		this.potencia = potencia;
		this.costoMana = costoMana;
		this.nivelDesbloqueo = nivelDesbloqueo;
		this.prioridad = prioridad;
	}
	
	public void MostrarHabilidad()
	{
		System.out.println(getNombre()+"Daño: "+getTipoDaño()+"Potencia: "+getPotencia()+"Costo mana: "+getCostoMana());
		System.out.println("------------------------");
	}
	
	public int getPrioridad()
	{
		return prioridad;
	}
	public String getNombre()
	{
		return nombre;
	}
	public String getTipoDaño()
	{
		return tipoDaño;
	}
	public float getPotencia() 
	{
		return potencia;
	}
	public int getCostoMana() 
	{
		return costoMana;
	}	
	public int getNivelDesbloqueo()
	{
		return nivelDesbloqueo;
	}
}

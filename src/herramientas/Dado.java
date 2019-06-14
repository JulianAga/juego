package herramientas;

import java.util.Random;

public class  Dado {

	static Random rand = new Random();
	
	public static int numeroAleatorio(int dim)
	{
		return rand.nextInt(dim);
	}
	public static int tirarDado(int dim)
	{
		return 1 + rand.nextInt(dim); //Se suma +1 para que el resultado no pueda dar 0.
	}
	
	public static int tirarDadoParametros(int min,int max)
	{
		return (int)(Math.random() * ( max - min )) + min;
	}
}

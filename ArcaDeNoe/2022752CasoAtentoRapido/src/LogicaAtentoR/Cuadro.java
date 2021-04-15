/**
 * 
 */
package LogicaAtentoR;

import java.util.Random;

/**
 * @author Felipe osorio zapata.
 *
 */
public class Cuadro {
	//atributos.
	private int cuadrosVisibles;
	//un atributo de tipo focus, para los bordes de color azul.
	
		


	//generar de forma aleatoria los cuadros que quiero tener. [1-8].
	public int getCuadrosVisibles() {
		Random aleatorio = new Random();
		cuadrosVisibles = aleatorio.nextInt(8)+1;
		return cuadrosVisibles;
	}


}


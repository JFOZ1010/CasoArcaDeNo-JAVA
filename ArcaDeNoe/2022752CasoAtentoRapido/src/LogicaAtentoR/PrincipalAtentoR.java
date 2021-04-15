/**
 * 
 */
package LogicaAtentoR;

import java.awt.EventQueue;

/**
 * @author Felipe 
 * purpose: clase principal para la ejecuciíon del juego. 
 *
 */
public class PrincipalAtentoR {
	
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				VistaGUIAtento ejecutable = new VistaGUIAtento();  //creado instancia de la clase. 
				
				
			}
			
		});
	}

}

/**
 * 
 */
package logicaArcaDeNoe;

import java.awt.EventQueue;

import javax.swing.UIManager;


/**
 * @author juanfelipeoz
 *
 */
public class PrincipalArcaDeNoe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// en java la interfaz grafica equivale a un subproceso.
		
		
		try {
			String JavaLookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
			//UIManager --- se encargara de mostrar como se visualizaran los componentes graficos. 
			//getCrossPlatformLookAndFeelClassName() ---- el metodo para poder obtener una referencia a toda la configuracion por defecto de las ventanas en java
			// INDEPENDIENTES DEL SISTEMA OPERATIVO. -- devuelve un string. 
			
			UIManager.setLookAndFeel(JavaLookAndFeel); //QUIERO QUE ESTA APLICACION VISUAL TENGA TODA LA CONFIGURACION POR DEFECTO PARA LA VENTANA.
			/**
			 * tomara en cuenta todas las excepciones que se llevan a cabo con manejar este metodo de getCrossPlatform... 
			 */
			
			// QUE NO SE ENCUENTRE LA CLASE CON LA REFERENCIA DEL STRING.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "OH, se ha detectado un posible error con la JVM. "); // para ahorrar codigo y no poner todas las excepciones.
			 
		}
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				ArcaDeNoe miVista = new ArcaDeNoe();
				
			}
			
			
			
		});
	}

}

/**
 * 
 */
package LogicaAtentoR;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/**
 * @author Felipe
 *
 */
public class VistaGUIAtento extends JFrame {
	// Atributos.
	private JLabel cuadro1, cuadro2, cuadro3, cuadro4, cuadro5, cuadro6, cuadro7, cuadro8;
	private JButton botonLanzar;
	private JButton botonSalir;
	private JTextArea mensajeM;
	private JTextArea vida;
	private JTextArea score;
	private JTextArea errores;
	private ImageIcon imagen; // clase que toma la clase icon que permite cargar images, jpg, png, etc...
	private Escucha escucha;
	private ControlCuadro controlCuadros;
	private Timer tiempo;
	private boolean clip;

	/*
	 * vistaGUIAtento(); --> constructor.
	 * dentro del constructor estarán todas las especificaciones basicas y necesarias de la interfaz. 
	 */
	public VistaGUIAtento() {
		initGUI();
		// configuracion por defecto de la ventana.
		this.setTitle("Juego Atento y Rapido.");
		// this.setSize(650, 400);
		this.pack(); // acomoda tamaño ventana, según las necesidades del pais.
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.black);

	}

	/**
	 * Metodo initGUI(); 
	 * purpose: dentro de este estarán todos los subprocesos que tendra a cabo toda la vista de usuario. 
	 * como metodo de buenas practicas, para que no haya desorden en codigo y sea más legible el mismo.
	 */
	private void initGUI() {
		
		//Iniciar audio
		
		
		// INICIAR CONTENEDOR.
		Container contenedor = this.getContentPane(); // me devuelve un objeto de tipo container. (contenedor de la ventana.)
		contenedor.setLayout(new GridBagLayout());
		contenedor.setPreferredSize(new Dimension(415, 300));
		contenedor.setBackground(Color.black);
		// contenedor.add(panel);

		// Restricciones.

		GridBagConstraints restricciones = new GridBagConstraints();

		// crear el ojeto escucha de ACTION - LISTENER... de tipo : Escucha , y tambien
		// crear el objeto controlcraps de tipo ControlCraps.

		// escucha = new Escucha(); //que es un objeto de tipo Escucha.
		escucha = new Escucha();
		controlCuadros = new ControlCuadro();
		tiempo = new Timer(2000, escucha);

		// Agregar los componentes graficos, pero primero toca crear las instancias
		// graficas.

		// imagen que es un objeto de tipo imageIcon.
		imagen = new ImageIcon("src/picturesAtentoR/1.jpeg"); // en el constructor se puede definir el camino donde
															  // encontrar la imagen. el camino.
		
		/**
		 * RESTRICCIONES(); ---> GridBagConstraints.
		 * con este diseño en especifico desde la linea 99 - 242. se implementaran factores graficos, textuales, con ciertos 
		 * aspectos parametrizados dados por coordenadas 'X' y 'Y' y se añadirán a la interfaz grafica. 
		 */
		
		//////////////////////////////////////// C U A D R O S /////////////////////////////////////////

		cuadro1 = new JLabel(imagen);
		restricciones.gridx = 0;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro1, restricciones);


		imagen = new ImageIcon("src/picturesAtentoR/2.jpeg");
		cuadro2 = new JLabel(imagen);
		restricciones.gridx = 1;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro2, restricciones);


		imagen = new ImageIcon("src/picturesAtentoR/3.jpeg");
		cuadro3 = new JLabel(imagen);
		restricciones.gridx = 2;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro3, restricciones);


		imagen = new ImageIcon("src/picturesAtentoR/4.jpeg");
		cuadro4 = new JLabel(imagen);
		restricciones.gridx = 3;
		restricciones.gridy = 0;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro4, restricciones);


		imagen = new ImageIcon("src/picturesAtentoR/5.jpeg");
		cuadro5 = new JLabel(imagen);
		restricciones.gridx = 0;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro5, restricciones);

		imagen = new ImageIcon("src/picturesAtentoR/6.jpeg");
		cuadro6 = new JLabel(imagen);
		restricciones.gridx = 1;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro6, restricciones);

		imagen = new ImageIcon("src/picturesAtentoR/7.jpeg");
		cuadro7 = new JLabel(imagen);
		restricciones.gridx = 2;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro7, restricciones);

		imagen = new ImageIcon("src/picturesAtentoR/8.jpeg");
		cuadro8 = new JLabel(imagen);
		restricciones.gridx = 3;
		restricciones.gridy = 1;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(cuadro8, restricciones);

		//////////////////////////////////////// C U A D R O S /////////////////////////////////////////
		
		
		// y asi ya Jlabel uno de las sobrecargas que tiene JLabel, es que permite
		// recibir un objeto de tipo ImageIcon, y se carga en su constructor.

		/////////////////////////////////////// B O T O N //////////////////////////////////////////////
		botonLanzar = new JButton("¡Start!");
		botonLanzar.setBackground(Color.BLACK);
		botonLanzar.addActionListener(escucha);
		restricciones.gridx = 1;
		restricciones.gridy = 4;
		restricciones.gridwidth = 2;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(botonLanzar, restricciones);
		
		botonSalir = new JButton("Exit");
		botonSalir.setBackground(Color.BLACK);
		botonSalir.addActionListener(escucha);
		restricciones.gridx = 3;
		restricciones.gridy = 4;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(botonSalir, restricciones);
		/////////////////////////////////////// B O T O N //////////////////////////////////////////////

		
		/////////////////////////////////////// M E N S A J E /////////////////////////////////////////
		mensajeM = new JTextArea("¡VAMOS, TÚ PUEDES! ");
		mensajeM.setBackground(Color.white);
		mensajeM.setForeground(Color.black);
		mensajeM.setEditable(false);
		restricciones.gridx = 1;
		restricciones.gridy = 5;
		restricciones.gridwidth = 2;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(mensajeM, restricciones);
		/////////////////////////////////////// M E N S A J E /////////////////////////////////////////


		/////////////////////////////////////// S C O R E //////////////////////////////////////////////
		score = new JTextArea("Score: ");
		score.setBackground(Color.WHITE);
		score.setForeground(Color.BLACK);
		score.setEditable(false);
		restricciones.gridx = 0;
		restricciones.gridy = 4;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(score, restricciones);
		// botonLanzar.addActionListener(escucha);
		
		/////////////////////////////////////// S C O R E //////////////////////////////////////////////

		
		/////////////////////////////////////// V I D A //////////////////////////////////////////////
		vida = new JTextArea("Vida: ");
		vida.setBackground(Color.WHITE);
		vida.setForeground(Color.BLACK);
		vida.setEditable(false);
		restricciones.gridx = 0;
		restricciones.gridy = 5;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(vida, restricciones);
		
		/////////////////////////////////////// V I D A  //////////////////////////////////////////////

		
		/////////////////////////////////////// E R R O R E S //////////////////////////////////////////////
		errores = new JTextArea(" Errores: ");
		errores.setBackground(Color.WHITE);
		errores.setForeground(Color.BLACK);
		errores.setEditable(false);
		restricciones.gridx = 0;
		restricciones.gridy = 7;
		restricciones.gridwidth = 1;
		restricciones.gridheight = 1;
		restricciones.fill = GridBagConstraints.NONE;
		add(errores, restricciones);
		/////////////////////////////////////// E R R O R E S //////////////////////////////////////////////

 

	}

	/**
	 * cuadrosBases(); 
	 * purpose: este metodo se encargara de poner en la interfaz con imagenes en especifico los cuadros correspondientes a
	 * cada posicion.
	 */
	public void cuadrosBases() {
		// repintar los cuadros iniciales dentro de la ventana.
		int[] cuadrosN = controlCuadros.getCuadros();

		// cuadro 1 - Base.
		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[0] + ".jpeg");
		cuadro1.setIcon(imagen);

		// cuadro 2 - Base.

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[1] + ".jpeg");
		cuadro2.setIcon(imagen);

		// cuadro 3 - Base.

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[2] + ".jpeg");
		cuadro3.setIcon(imagen);

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[3] + ".jpeg");
		cuadro4.setIcon(imagen);

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[4] + ".jpeg");
		cuadro5.setIcon(imagen);

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[5] + ".jpeg");
		cuadro6.setIcon(imagen);

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[6] + ".jpeg");
		cuadro7.setIcon(imagen);

		imagen = new ImageIcon("src/picturesAtentoR/" + cuadrosN[7] + ".jpeg");
		cuadro8.setIcon(imagen);

		// controlCuadros.calcularAciertos();

	}

	private class Escucha implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				//AudioClip Sound;
				//Sound = java.applet.Applet.newAudioClip(getClass().getResource("src/SonidoGOT/GOT.wav"));
			//controlCuadros.pedirNombreUsuario();
			
			if (e.getSource() == botonLanzar) {
				

				if (botonLanzar.getText() == "¡Start!") {
					
					botonLanzar.setText("¡Presionar!");
					
					tiempo.start(); // empezara a contar el tiempo y dara una alerta despues de mi tiempo.
						int[] cuadrosN = controlCuadros.getCuadros();
					    // controlCuadros.iniciarCuadros();
					    controlCuadros.inicializarCuadros();
					    
					    //tiempo.stop();
						
						
					       SwingUtilities.invokeLater(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub

									cuadrosBases();

								}

							});
						
						
					}else if(e.getSource() == botonLanzar) {
							   tiempo.stop();
							   controlCuadros.cambiosCuadros();
						
					    	   clip = true;
					    	   controlCuadros.cuadrosPares();
					    	   controlCuadros.click(clip);
					    	   controlCuadros.clickear();
						
						
						//MUestra en la interfaz en tiempo real el proceso...
						
						score.setText("Score: " + String.valueOf(controlCuadros.devolverPuntaje()));
						vida.setText("Vida: " + String.valueOf(controlCuadros.devolverVida()));
						errores.setText(" Aciertos: " + String.valueOf(controlCuadros.devolverAcierto()));
						tiempo.start();
						
					//}

					
				}
						
						
						
					}else{
						
						clip = false; // se establece en falso el clip, haciendo referencia a que no se ha dado click.
						controlCuadros.click(clip); //false, se supone no se clickea. 
						controlCuadros.noClickear(); // metodo solo para cuando no se clickea. 
						//controlCuadros.click(true);

						//score.setText("Score: " + String.valueOf(controlCuadros.devolverPuntaje()));
						//vida.setText("Vida: " + String.valueOf(controlCuadros.devolverVida()));
						//errores.setText(" Errores: " + String.valueOf(controlCuadros.devolverErrores()));

					}
					//tiempo.stop();
					//controlCuadros.cambiosCuadros(); //los cambios de cuadros se vayan efectuando...
					//controlCuadros.cuadrosPares();
					//controlCuadros.mostrarRondaFinal();
					//score.setText("Score: " + String.valueOf(controlCuadros.devolverPuntaje()));
					//cuadrosBases();
					tiempo.start();

					
				

	
			
					if(e.getSource() == botonSalir) {
			
						controlCuadros.mostrarRondaFinal(); //un joption pane para mostrar toda la info correspondiente final. 
						System.exit(0);
					
					}
		
			if (e.getSource() == tiempo) {
				// System.out.println("cambio en el timer.");
				if(controlCuadros.devolverVida() > 0) { //mientras haya vida habra tiempo y cambios de cuadros. 
				controlCuadros.cambiosCuadros();
				SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			cuadrosBases(); // toma en cuenta los cuadros bases que se seguirán en el programa tomando en
							// cuenta, en la inicializacion primaria.

		}

	});
 }
}

}

}

}

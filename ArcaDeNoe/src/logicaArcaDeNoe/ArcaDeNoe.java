/**
 * 
 */
package logicaArcaDeNoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
//import javax.swing.Timer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import misComponentes.Titulos;

/**
 * @author juanfelipeoz
 *
 */
public class ArcaDeNoe extends JFrame {
	//atributos. 
	//public static String rutaFile = "src/imagenes/";
	private int fichaCarta = 110; //este es el tamanio de mis imagenes, cada carta. 
	private int gridSizeC = 4; 
	private int gridSizeF = 3; 
	private Cartas [][] tablero = new Cartas[gridSizeF][gridSizeC]; //ES DE 4X3, PORQUE LA MATRIZ LA MODELÉ ASI. 
	private JPanel panelCentral, panelBotones; //panel botones será: iniciar, salir, reiniciar, aunque habrá un setText que me mostrara el puntaje. 
	private JButton reiniciar, iniciar, salir; // botones de la GUI. 
	private JTextArea score; //Puntaje a mostrar en la GUI. 
	private JTextArea tiempoRestante; //tiempo para las rondas. 
	private Cartas carta;   //FALTABA INICIALIZAR ESTA MADRE 
	private ImageIcon imagenCartas; 
	private Vector<Cartas>numeroCartas = new Vector(12); 
	private Escucha escucha; //actionListener . 
	private Timer tiempo;
	private Timer tiempoCartasIguales; 
	private static int contrareloj = 25;  //tiempo predeterminado para mi juego. 
	private static Vector<Cartas> cartasClear = new Vector(2);
	private static boolean condicion = false; 
	//varibale para los tiempos en rondas. 
	private int tamanioRonda = 4; 
	private int incrementoClick = 0; 
	private ImageIcon fondoGUI; 
	private int varCero = 0; 
	private int incrementoRonda = 6; 
	
	
	
	public ArcaDeNoe() {
				
		initGUI();
		
		//no tener ningun cierrre en la ventana que no aparezca nada.
		this.setUndecorated(true);
		pack(); //calcular automaticamente el tamanio de la ventana. 
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
	}
	
	private void initGUI() {
		
		
		carta = new Cartas();
		//task = new TimerTask();
		tiempo = new Timer(); //java.util.Timer; 
		tiempoCartasIguales = new Timer();
		escucha = new Escucha(); 
		
		
		//titulo ventana. 
		Titulos titulo  = new Titulos("Arca De Noé", 30, Color.black);
		add(titulo, BorderLayout.NORTH);
		 
		
		
		//inicializar el jpanel. 
		fondoGUI = new ImageIcon("src/imagenes/madagascar.jpeg");
		panelCentral = new JPanel();
		
		panelCentral.setLayout(new GridLayout(gridSizeF, gridSizeC)); //establecer el tamaño del panel y junto con su diseño. 
		pintarCartas();
		add(panelCentral, BorderLayout.CENTER); 
		//panel de botones. 
		
		panelBotones = new JPanel();
		
		
		reiniciar = new JButton("Reiniciar");
		reiniciar.setForeground(Color.white);
		reiniciar.setBackground(Color.BLACK);
		reiniciar.addActionListener(escucha);
		panelBotones.add(reiniciar);
		
		iniciar = new JButton("Iniciar");
		iniciar.setForeground(Color.white);
		iniciar.setBackground(Color.BLACK);
		iniciar.addActionListener(escucha);
		panelBotones.add(iniciar);
		
		salir = new JButton("Salir");
		salir.setForeground(Color.white);
		salir.setBackground(Color.BLACK);
		salir.addActionListener(escucha);
		panelBotones.add(salir);
		
		//direccionamiento de estos botones. 
		add(panelBotones, BorderLayout.SOUTH);
		
		score = new JTextArea(" Score: ");
		score.setBackground(Color.black);
		score.setForeground(Color.white);
		score.setEditable(false);
		add(score, BorderLayout.BEFORE_LINE_BEGINS);
		
		//cronometro.start();
		tiempoRestante = new JTextArea("Tiempo: ");
		tiempoRestante.setForeground(Color.white);
		tiempoRestante.setBackground(Color.black);
		tiempoRestante.setEditable(false);
		add(tiempoRestante, BorderLayout.AFTER_LINE_ENDS);
		
		
		
		
	}
	
	/**
	 * pintarCartas(); 
	 * purpose: este metodo dew tomar las imagenes, inicialemente la base como muestra principal. 
	 * y me ira recorriendo la matriz de mi	 GUI e irá agregando en esa matriz el panel central y el numero de cartas que será
	 * mi Vector con las 12 posiciones. 
	 */
	private void pintarCartas() {
		
		imagenCartas = new ImageIcon("src/imagenes/0.jpeg"); //se agrega la imagen base. 
		
		for(int f= 0; f<gridSizeF; f++) { //RECORRIENDO filas de la matriz. 
			for(int c=0; c<gridSizeC; c++) { //recorriendo las columnas.
				tablero[f][c] = new Cartas(imagenCartas);
				tablero[f][c].addMouseListener(escucha);
				panelCentral.add(tablero[f][c]);
				numeroCartas.addElement(tablero[f][c]); //el numero de cartas es un vector que almacena el valor de 12, para mis 12 posiciones de imagenes. 
				
			}
		}
		
		
	}
	/**
	 * @param numCartas
	 * conteoRondas();
	 * purpose: con este metodo se irá poniendo cada imagen en la interfaz, Gradualmente. 
	 * return imagenCartas; 
	 * 
	 */
	private void conteoRondas(int numCartas) {

		for(int i = 0; i<numCartas; i++) {
			numeroCartas.elementAt(i).setVisible(true);// me ira poniendo en numero cartas las posiciones 1,2,3,4,5 y asi sucesivamente
													// hasta 12 para poder mostrarmelas y ponerlas visibles. 
			numeroCartas.elementAt(i).setPermanenciaCartasIguales(false);
			numeroCartas.elementAt(i).setIcon(imagenCartas);
			numeroCartas.elementAt(i).setId(0); 
		}
		
		
		
	}
	
	
	/**
	 * timer(); 
	 * purpose: este metodo se encargará automaticamente apenas de en el boton Iniciar, comenzar un conteo de cronometro descendente 
	 * de 25 segundos y si se acaba el tiempo, se acaba la partida. 
	 */
	private void timer() {
		 
		TimerTask task =  new TimerTask() {
			public void run() {
				//variable contrareloj -- atributo entero de mi clase ArcaDeNoe con un valor de 25. 
				contrareloj--;
				tiempoRestante.setText("  Time: " + contrareloj);
				if(contrareloj <= 0 || carta.getPuntaje() < 0) {
					JOptionPane.showMessageDialog(null, "Tu tiempo, se ha excedido. ");
					datosPartida(); 
					System.exit(0);
				}else if(carta.getPuntaje() >= 320) {
					juegoGanado(); 
					System.exit(0); 
					
				}
				
			}
		};
		tiempo.schedule(task, 1000, 1000); //este será el tiempo con el que se contabilizará continuamente el decremento de la 
		//variable contrareloj--; 

		
	}
	
	/**
	 * @Autho: Jun Felipe Osorio Zapata. 
	 * datosPartida();
	 * purpose: el proposito de este metodo sera poder mostrar mediante un JOptionPane los datos de cada partida.
	 * si pierde, si se sale.  
	 */
	
	
	public void datosPartida() {
		
		
		JOptionPane.showMessageDialog(null, "Lamentamos que salgas del juego. "
				+ "\ntu puntaje fue de: " + carta.getPuntaje());
		
		
	}
	
	/**
	 * juegoGanado(); 
	 * purpose: sé que esto no es codigo recursivo ni mucho menos optimo, but this is the method for when the round arrived to the
	 * final.
	 */
	public void juegoGanado() {
		
		JOptionPane.showMessageDialog(null, "Felicidades, enhorabuena has ganado el juego con un puntaje de: " + carta.getPuntaje() +
											"\ny con un tiempo restante de: " + contrareloj ); 
		
		
	}
	
	
	/**
	 * timerCambiar(); 
	 * purpose: este metodo está creado con el purpose de poder establecer la similaridad de las imagenes en caso tal
	 * de que no sean iguales las imagenes se establecerán con la imagen Base, si las imagenes son iguales automaticamente se omiten de la GUI. 
	 * return cambiosImagenes; 
	 */
	private void timerCambiar() {
		
		TimerTask taskCambiar = new TimerTask() {
			public void run() {
				
				score.setText("  Score: " + String.valueOf(carta.getPuntaje()));

				
				if(carta.isCartasIguales()) {
					
					
					carta.setCartasIguales(false);
					for(int i=0; i<2; i++) {
						cartasClear.elementAt(i).setVisible(false);
						
					}
					
					// System.out.println("getSeis: " + carta.getSeis());
					// System.out.println("varCero: " + varCero);
					
					varCero++; 
					if(varCero == carta.getVarDos()){
						
						varCero = 0; 
						contrareloj = 35; //se reestablece en 25 de nuevo en las nuevas rondas del juego. 
						
						carta.sucesionRondas(); //para poder reinciar las rondas... 
						conteoRondas(incrementoRonda);
						incrementoRonda += 2; 
					}
					
						
				}else if(incrementoClick %2 == 0 && incrementoClick != 0){
					
					for(int i=0; i<2; i++) {
						cartasClear.elementAt(i).setIcon(imagenCartas);
					}
				}
			 }
			
		
	};
	
	tiempoCartasIguales.schedule(taskCambiar, 2000, 1000000000); //este es el tiempo con el que se realizará constantemente el metodo.

	
	}
	
	/**
	 * reiniciarPartida(); 
	 * purpose: esta funcion lo que busca es poder reiniciar la partida poniendo ciertos elementos en sus valores
	 * iniciales por defecto y asi poder empezar de nuevo la partida inicial (BASE). 
	 * Return partidaInicial; 
	 */
	public void reiniciarPartida() {
		
		
		for(int i = 0; i<12; i++) {
			numeroCartas.elementAt(i).setVisible(false);// me ira poniendo en numero cartas las posiciones 1,2,3,4,5 y asi sucesivamente
													// hasta 12 para poder mostrarmelas y ponerlas visibles. 
			numeroCartas.elementAt(i).setPermanenciaCartasIguales(false);
			numeroCartas.elementAt(i).setIcon(imagenCartas);
			numeroCartas.elementAt(i).setId(0); 
		}
		
		
	}
	
	
	/**
	 * clickear(); 
	 * @param lasCartas;
	 * purpose: este metodo será el que me llevara a cabo el proceso directo de lo que vendra a ser el cambio de imagen
	 * de la base a una de algun animal cuando se de CLICK e igualemente a obtenerme las imagenes, este metodo se llamará en el mouseListener, y tomara un llamado al
	 * metodo timerCambiar(); para poder establecer las imagenes cuando se cumplan las condicione e igualmente quitarlas visualmente
	 * de la GUI cuando la condicion se dé. 
	 */
	private void clickear(Cartas lasCartas) {
		
		carta.inicializarVectores(lasCartas);

		
		if(lasCartas.isPermanenciaCartasIguales() == false) {
			
			
			lasCartas.setIcon(carta.getCartasImagen());
			lasCartas.setPermanenciaCartasIguales(true);
		}else {
			lasCartas.setIcon(lasCartas.getImagenBase());
			lasCartas.getImagenBase();
		}
		cartasClear.addElement(lasCartas);
		
		if(condicion == false) {
			
			cartasClear.insertElementAt(lasCartas, 0);
			condicion = true; 
		}else {
			
			cartasClear.insertElementAt(lasCartas, 1);
			condicion = false; 
		}
		timerCambiar();

		incrementoClick++;
	}
	
	private class Escucha extends MouseAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == iniciar) {
				
				timer(); //llamando a la funcion de timer para que se tome en cuenta el contrareloj. 
				//timerCambiar();
				conteoRondas(tamanioRonda); //en este momento tamanioRonda equivale a 4.
				  //pero en esta linea cambia a incrementarse solo en 2, porque los cuadros se mostrarán de dos en dos,
									//despues de la primera ronda. 
				tamanioRonda += 2;
				
				
				 SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stud	
							
							
						}
						

					});
		
				
				
					//aqui tengo que reiniciar mi partida. 
			}else if(e.getSource() == reiniciar) {
				
				reiniciarPartida(); 
				carta.reiniciarJuego();
				incrementoRonda = 6; //¿porque en 6? porque el incremento que se tomarà en cuenta sera dos cuadro más con los base que tengo que son 4 + 2 = 6. 
				varCero = 0; 
				conteoRondas(4); //en este momento tamanioRonda equivale a 4.


			}else if(e.getSource() == salir) {
				
				datosPartida(); 
				System.exit(0); //salir instantanemente de la partida. 
			}
			
			
		}
		
		@Override
		public void mouseClicked(MouseEvent eventMouse) {
	        //intercambiar las fichas .... 
			//tiempo.start(); 
			
			// el metodo eventSource recibe el escucha de lo que obtiene pero lo recibe como un tipo de objeto generico,
			//y si llamamos al metodo clickCarta(), con el objeto generico que nos pase el escucha, no lo reconoceria,
			//es por eso que se tiene que hacer la conversion del escucha para uno de tipo Carta de la clase.
			
			
			//FIUUUUUUUU
			  SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						//boolean variable = false;  //false es que no se encuentran imagenes iguales. 
						//carta.cartasIguales(variable);
						//if(variable == true) {
							
						Cartas clickCarta = (Cartas)eventMouse.getSource();
						clickear(clickCarta); //se llama a este metodo que basicamente sera el que iniciara los vectores y pondra el getImage para poder mostrarlas,
											 // con cada click que de sobre una image. 
							
												
						
					}

				});

		}
		
	}
	
}

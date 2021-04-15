/**
 * 
 */
package logicaArcaDeNoe;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author juanfelipeoz
 * clase Cartas();
 * purpose: clase encargada de toda la logica computacional que llevará mi juego de  Arca De Noe. 
 * desde los puntos (puntaje) a obtener con ciertas reglas , hasta hacer cambios de imagenes, quitarlas, poner nuevas, etc...  
 *
 */
public class Cartas extends JButton {
	//atributos... //y que el maximo de cartas seran 12. 
	private static int maxCartas = 110; //(AGAIN READ!!!)  -- el numero maximo de cartas que habrán que serán: 12 cartas, tendré que hacer un metodo para involucrar el tamaño de cartas en la GUI.
	private static int cartasSize = 110; // el tamaño asigando para las cartas que quiero mostrar...
	private static int var = 0; //mi var de 0 hace referencia a mi imagen cero que es la imagen base para todas antes del click.
	//private static int varPrueba = 0; 
	public static  int var2; 
	private static int puntaje = 0; 
	private int filas; // matriz. 
	private int columnas; //para poder tomar en cuenta -- matriz
	private int idCartas; //las imagenes estarán posicionada en un orden especifico matricial.
	private ImageIcon cartasImagen, imagenBase; //estableceré mis imagenes, cada una de las que aparecerán en la GUI
	private int [] imagenesCartas; //numero de cartas y serán almacenadas en un vector.  
	private static int cartasBases = 4; //numero de cartas iniciales --- 4. , aumenta de dos en dos timer. 
	//private Cartas miMisma; 
	private boolean mismasCartas; 
	private static int varDos = 2; // 3, 5, 8, 9 
	private static int ronda = 1; // //
	private static int varPrueba = 0;
    private static int varTemporal = 1; //llamandose en la funcion inicializarVector(); 
    private static int seis = 2;  //se aumenta seis en timer. de 1 en 1. 
	private static int varTres = 3; 
    private Cartas cartas;
	private static boolean boo = false; 
    private int id = 0; //no es estatico, porque puede cambiar. 
	private Random aleatorioImagenes = new Random(); 
    private static boolean cartasIguales = false; 
	private static int guardarVar = 0; 
    private static int presionarClick = 0; 
    private static int clickContinuo = 1;
    private boolean permanenciaCartasIguales = false; 
    private static int rondasJuego = 0; //rondas que se llevan en el juego. 
	private static Vector<Integer> pintarPrimerasCartas = new Vector<Integer>();  

	
	public Cartas() {
		
	}
	
	
	public Cartas(ImageIcon imagen) {
		
		imagenesCartas = new int[12]; //numero de cartas que tendre para mi interfaz, este es el numero maximo. 
		
		
		//Nota importante para leer mañana: las imagenes que guarde las almacenaré como numeros para tenerlas asi presente en mi vector de
		//la clase control.

		
		this.setIcon(imagen);
		this.setBackground(Color.RED); //este será el color de cada carta por defecto cuando la imagen no se ha puesto. 
		
		//establecer tamaño. 
		Dimension size = new Dimension(cartasSize, cartasSize);
		this.setPreferredSize(size);
		this.setVisible(false);
		this.setFocusPainted(true);
		

	}
	
	
	
	/**
	 * getImagenCartas(); 
	 * @return las imagenes con los cuadros, CLARAMENTE una vez yo he hecho un click en la imagen por defecto ahi entonces
	 * me retornara mi imagen real. 
	 */
	public int[] getImagenesCartas() {
		
		return imagenesCartas; 
		
	}
	
	/**
	 * 
	 * autor: Juan Felipe Osorio Zapata. 
	 * @param objCartas
	 * purpose: este metodo se encargará de poder establecer en la serie de rondas del juego,
	 * las condiciones dadas especificas para cada ronda de juego, en la animacion de cuando estan dos parejas de cartas iguales
	 * para poder cuando han sido ambas seleccionadas en el juego poder eliminarlas de la interfaz GUI y para eso se almacenan con
	 * Vector para utilizar el metodo .Remove(); y junto con las condiciones del atributo clickContinuo(); para dar referencia a condiciones 
	 * especificas bases para poder dar paso ala seleccion de imagenes iguales y que se establezcan de nuevo como imagen base sino son iguales,
	 * y si lo son entonces eliminarlas de la interfaz y seguir con las demas obteniendo como puntaje +50 en la primera ronda, y en las siguientes
	 * de 20 en 20. 
	 * otro factor importante a nombrar es que desde la linea 173 - 184 las condiciones que se dan ahi serán ahi esenciales porque mi interfaz la dividire en dos partes, 
	 * las primeras 6 imagenes seran 6 diferentes una de otra, y las otras 6 seran los parejas iguales a las 6 primeras iniciales.
	 * 
	 * 
	 */
	
	public void inicializarVectores(Cartas objCartas ) {
		
		
			//var = aleatorioImagenes.nextInt(2+1);
			
		if (ronda == 1) {
			
			for(int i= 1; i<=cartasBases; i++) {

			 if(i %2 == 1 ) {
				 
					var = aleatorioImagenes.nextInt(2)+i;
					//varPrueba  = i;
					//System.out.println("este es var " + varPrueba);

					//System.out.println("----- este es var ----- " + var);
				    


				}
				
				   pintarPrimerasCartas.addElement(var);
				   //objCartas.id = var;		

				
			}
		}
			
		
			
	
		
		if(objCartas.permanenciaCartasIguales == false) {
			
			if (varTemporal <=  seis) {
				var = varTemporal;
				
				
				varTemporal++;
			}
			
			if(varTemporal == varTres && boo) {
				seis -= 1; 
				var = seis; 
				//System.out.println("var: " + var);
			}	
			
			cartasImagen = new ImageIcon("src/imagenes/" + pintarPrimerasCartas.elementAt(var) + ".jpeg"); //
			objCartas.imagenBase = cartasImagen;
			
			/**
			 * en esta serie de condicionales estamos aportando pa`saber exactamente cuando esta en la interfaz, tal numero de imagene
			 * entonces añadirle un "id" idebtificador para posteriormente con ese id comparar las imagenes iguales. 
			 * 
			 */
			
			if((int)pintarPrimerasCartas.elementAt(var) == 1 || (int)pintarPrimerasCartas.elementAt(var) == 2) {
				
			   objCartas.id = 1; 
			  
			}else if((int)pintarPrimerasCartas.elementAt(var) == 3 || (int)pintarPrimerasCartas.elementAt(var) == 4) {
				
				objCartas.id = 3;
				
			}else if((int)pintarPrimerasCartas.elementAt(var) == 5 || (int)pintarPrimerasCartas.elementAt(var) == 6) {
				
				objCartas.id = 4; 
				
			}else if((int)pintarPrimerasCartas.elementAt(var) == 7 || (int)pintarPrimerasCartas.elementAt(var) == 8) {
				
				objCartas.id = 5; 
				
			}else if((int)pintarPrimerasCartas.elementAt(var) == 9 || (int)pintarPrimerasCartas.elementAt(var) == 10) {
				
				objCartas.id = 6;
				
			}else if((int)pintarPrimerasCartas.elementAt(var) == 11 || (int)pintarPrimerasCartas.elementAt(var) == 12) {
				
				objCartas.id = 7;
			}
			
			pintarPrimerasCartas.removeElementAt(var);

			if(varTemporal == varTres) {
				boo = true; 
			}
			
			
		}
		//System.out.println("objCartas.id: " + objCartas.id); //SOUT para saber el estado del id. "objCartas"

		if(clickContinuo %2 == 0 && clickContinuo != 0 ) {
			//System.out.println("Cartas.id: " + cartas.id); //estos SOUT, fueron para verificar la eficacia de mi metodo. 
			//System.out.println("objCartas.id: " + objCartas.id);

			
			if(cartas.id == objCartas.id) { //condicion para ver si dos imagenes son iguales. 
				cartasIguales = true; 
				if(ronda == 1) {
				   puntaje += 50; //estableceré  mis puntaje en más 50 de primera ronda, como el juego de muestra. 
				}
				  puntaje += 20; //despues de la primera ronda el puntaje que se establezca sera de +20. 
				
				System.out.println("Cartas Iguales. "); //si son iguales se establecera +20 de puntos, de lo contrario. 
			}else {
				System.out.println("No son iguales.");
				
				if(rondasJuego %2 == 0 && rondasJuego != 0) {
					
					puntaje -= 20; //se restaran los 20 ganados. 
					
				}
				rondasJuego ++; // y la primera ronda
			}
		}
		
		
		cartas = objCartas; //cartas que es el objeto que se llama asi mismo en su propia clase, para la condicion de imagenes similares.
		clickContinuo += 1; //el click continuo se seguirá aumetando, porque este hace referencia a cualquier click que se lleva a cabo en la GUI "Posicion matricial".
		ronda = 2;  //la ronda se iguala a dos haciendo enfasis para poder hacer todo el proceso ademas de la ronda 1. 

		
	}
	
	
	/**
	 * @aUTOR: Juan Felipe Osorio Z. 
	 * reiniciarJuego();
	 * purpose: el proposito de este metodo es poder darle los valores por defecto a los atributos que se manejan para las 
	 * rondas, establecimiento de imagenes, rondas, a su puntaje inicial con el fin de poder mantener los valores por default
	 * par cada ronda seccion que se tendrá en cuenta en el juego, y poder evitar posibles fallos por almacenamiento errado en algunas
	 * variables, etc...y con esto poder llamar este metodo en la GUI. 
	 */
	public void reiniciarJuego() {
		
		varDos = 2; 
		seis = 2; 
		varTres = 3; 
		cartasBases = 4; 
		ronda = 1; 
		clickContinuo = 1; 
		varTemporal = 1; 
		boo = false; 
		cartasIguales = false; 
		rondasJuego = 0; 
		pintarPrimerasCartas.removeAllElements();
		
	}
	
	/**
	 * @Author: juan felipe osorio zapata. 
	 * purpose: este metodo se encargara de establecer ciertos componentes especificos a sus valores predeterminados, 
	 * y otros a valores incrementados con constancia para poder hacer referencia a las siguientes secciones del juego -- rondas. 
	 */
	public void sucesionRondas() {
		
		varDos++;
		seis = varDos;
		varTres++;
		cartasBases += 2; 
		ronda = 1; 
		var = 0; 
		clickContinuo = 1;
		varTemporal = 1; 
		boo = false; 
		cartasIguales = false; 
		rondasJuego = 0; 
		pintarPrimerasCartas.removeAllElements();
		
	}
	
	
	/**
	 * @return the varDos
	 */
	public static int getVarDos() {
		return varDos;
	}


	/**
	 * @param varDos the varDos to set
	 */
	public static void setVarDos(int varDos) {
		Cartas.varDos = varDos;
	}


	/**
	 * @return the imagenBase
	 */
	public ImageIcon getImagenBase() {
		return imagenBase;
	}

	/**
	 * @return the permanenciaCartasIguales
	 */
	public boolean isPermanenciaCartasIguales() {
		return permanenciaCartasIguales;
	}

	/**
	 * @param permanenciaCartasIguales the permanenciaCartasIguales to set
	 */
	public void setPermanenciaCartasIguales(boolean permanenciaCartasIguales) {
		this.permanenciaCartasIguales = permanenciaCartasIguales;
	}
	
	
	public int getPuntaje() {
		//cartasIguales();
		
		   return puntaje; 
	}
	
		
	/**
	 * este metodo se encarga de poder retornar mi vector de pintarPrimerasCartas para poder obtenerlo y todo lo que este
	 * contenga. 
	 * @return pintarPrimerasCartas; 
	 */
	
	public Vector<Integer> getPintarPrimerasCartas() {
		return pintarPrimerasCartas;
	}


	public int getIdCartas() {
		return idCartas;
	}

	public ImageIcon getCartasImagen() {
		return cartasImagen;
	}


    
    /**
 	 * @return the cartas
 	 */
 	public Cartas getCartas() {
 		return cartas;
 	}
    
    /**
     * este metodo me retorna el booleano de cartas iguales. 
	 * @return the cartasIguales
	 */
	public static boolean isCartasIguales() {
		return cartasIguales;
		
	}


	/**
	 * este metodo se encarga de poder retornar un numero dado especifico, 
	 * haciendo enfasis en si se da click o no.
	 * @return the presionarClick
	 */
	public static int getPresionarClick() {
		return presionarClick;
	}

	/**
	 * setter del atributo presionarClick. 
	 * @param presionarClick the presionarClick to set
	 */
	public static void setPresionarClick(int presionarClick) {
		Cartas.presionarClick = presionarClick;
	}

	/**
	 * @param cartasIguales the cartasIguales to set
	 */
	public static void setCartasIguales(boolean cartasIguales) {
		Cartas.cartasIguales = cartasIguales;
	}

    /**
	 * @return the seis
	 */
	public static int getSeis() {
		return seis;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	
}

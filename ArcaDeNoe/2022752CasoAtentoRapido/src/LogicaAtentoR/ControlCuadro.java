/**
 * 
 */
package LogicaAtentoR;

import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * @author Juan Felipe osorio. 
 * purpose: este es nuestra clase ControlCuadro que lo que hará será modelar toda la logica del juego y consecuente a eso
 * concluir y establecer el (puntaje,acierto, error, vida); 
 * return Methods; 
 *
 */
public class ControlCuadro {

	private Cuadro cuadro1, cuadro2, cuadro3, cuadro4, cuadro5, cuadro6, cuadro7, cuadro8;
	private int[] imagenesCuadros;
	private int var = 3; //numero de cuadros iniciales. 
	private int var3; 
	private boolean presionarBoton; //true es que se presiona boton - false es que no presiona boton de la GUI.
	private boolean identificadorPares;
	private Player jugador;
	private Vector<Integer> posicionesIguales = new Vector<Integer>();
	private Vector<Integer> pintarPrimerCuadro = new Vector<Integer>();
	
	
	
	/**
	 * @autor: juan felipe osorio zapata. 
	 * @param lista1: toma en cuenta la lista como referencia de los cuadros que hay y asi mismo se conectará con lo demás del metodo.
	 * @param elementoBuscar: se encargará basicamente de poder conseguir de los 8 elementos de cuadros que hay buscar los que sean iguales.
	 * @return boolean; 
	 */
	public boolean buscarElementosV(int [] lista1, int elementoBuscar){
		for(int f= 0; f < lista1.length; f++){
			if(elementoBuscar == lista1[f]){
				return true;
			}
		}
				return false;
	}
/*
 * controlCuadro(); --> Constructor. 
 * purpose: este es el constructor de nuestra clase Control en el que se instanciaran los objetos de la misma y los demás objetos 
 * provenientes de otras clases. 
 * 
 */
	public ControlCuadro() {
		cuadro1 = new Cuadro();
		cuadro2 = new Cuadro();
		cuadro3 = new Cuadro();
		cuadro4 = new Cuadro();
		cuadro5 = new Cuadro();
		cuadro6 = new Cuadro();
		cuadro7 = new Cuadro();
		jugador = new Player(); //instancia clase player... 
		imagenesCuadros = new int[9];

	}

/*
 * GetCuadros();
 * purpose: este metodo se encargará de retornar las imagenes de los cuadros del array de 8 elementos que hay para almacenar cada imagen.
 * return imagenesCuadros;
 */
	public int[] getCuadros() {
		return imagenesCuadros;
	}

/*
 * iniciarCuadros();
 * purpose: metodo encargado de iniciar los cuadros primarios 'bases' del juego, posterior a eso igualar los demas cuadros a una imagen en 
 * especifico bloqueada conforme se avance en el juego. 
 */
	public void iniciarCuadros() {

		imagenesCuadros[0] = cuadro1.getCuadrosVisibles();
		imagenesCuadros[1] = cuadro2.getCuadrosVisibles();
		imagenesCuadros[2] = cuadro3.getCuadrosVisibles();
		imagenesCuadros[3] = 0; // igualadas a cero porque 0 es la imagen 'bloqueada', que aparecerá mientras no
								// se avance de nivel.
		imagenesCuadros[4] = 0;
		imagenesCuadros[6] = 0;
		imagenesCuadros[7] = 0;
		imagenesCuadros[8] = 0;

		// for(int i = 0; i < 3; i++) {
		// System.out.println(imagenesCuadros[i]);
		// }
	}
	
/*
 * inicializarVector();
 * purpose: este metodo me inicia mediante un vector el proceso de ir pintando 'agregando' los cuadros y siendo almacenados en el vector.
 * return añadir elementos 'cuadros' al vector;	
 */
	public void inicializarVector() {
		pintarPrimerCuadro = new Vector();
		
		// añadiendo valores manualmente al vector. 
		pintarPrimerCuadro.addElement(1);
		pintarPrimerCuadro.addElement(2);
		pintarPrimerCuadro.addElement(3);
		pintarPrimerCuadro.addElement(4);
		pintarPrimerCuadro.addElement(5);
		pintarPrimerCuadro.addElement(6);
		pintarPrimerCuadro.addElement(7);
		pintarPrimerCuadro.addElement(8);

	}
	
	
/*
 * inicializarCuadros();	
 * Purpose: con este metodo lo que se busca de forma primaria es poder instanciar en la interfaz de forma base los cuadros que
 * saldrán de primeros en la ejecución central del juego, de forma aleatoria y sin un orden en especifico.  
 * return pintarPrimerCuadro() -->  de forma aleatoria.
 */
	public void inicializarCuadros(){
		inicializarVector();
		
		for(int k= 0; k < var; k++ ){
				int var2 = pintarPrimerCuadro.size(); //para que no tome lugares que no estén disponibles/no existen '.remove(algo2)'. 
				Random algo = new Random();
				int algo2 = algo.nextInt(var2);
				imagenesCuadros[k] = pintarPrimerCuadro.elementAt(algo2);
				pintarPrimerCuadro.removeElementAt(algo2); // va a remover que va a tener el vector, para que no se repita - vector solo es para llenar la posicion. 		
		}
		
		for(int j= var; j < 8; j++ ){
			
			imagenesCuadros[j] = 0; //ir llenando los cuadros faltantes en imagenes bloquedadas. 
		}
		
		
	}

	/**
	 * Buscar cuadros iguales que se encuentren dentro de la ejecucion del
	 * juego/ventana, este solo es un metodo que se basa en ver desde la consola del IDE,
	 * si los cuadros que salen son iguales o difieren un o del otro junto con las posiciones que se tienen del vector,
	 * que se creo anteriormente. 
	 * 
	 */
/*
	public void verCuadros() {

		for (int c = 0; c < imagenesCuadros.length; c++) {

			System.out.println("Cuadro: " + imagenesCuadros[c]);
		}

		for (int f = 0; f < posicionesIguales.size(); f++) {

			System.out.println("Vector: " + posicionesIguales.elementAt(f));
		}

	}
*/
	
	/**
	 * public void cuadrosGemelos(){ int [] tamanioC = new int [] {1,2,3,4,5,6,7,8};
	 * //tamanio cuadros... int j=0; for(int i = 0; i < imagenesCuadros.length;
	 * i++){ //if(imagenesCuadros[i] == 1){ // posicionesIguales.add(i);
	 * 
	 * //}
	 * 
	 * if(imagenesCuadros[i] == tamanioC[j]){ posicionesIguales.add(i);
	 * System.out.println(tamanioC[i]); }
	 * 
	 * if(i == imagenesCuadros.length-1 && j < tamanioC.length-1) { j++; i = 0; } }
	 * }
	 */

	/*
	public void calcularAciertos() {

		while (inicioJuego == true) {

			// inicio mi juego con tres cuadros Bases en mi interfaz.

			if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[1] == imagenesCuadros[2]) {
				// acierto += 5;
				jugador.setPuntaje();
				imagenesCuadros[3] = cuadro4.getCuadrosVisibles();
			} else if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[0] == imagenesCuadros[3] || imagenesCuadros[1] == imagenesCuadros[0]
					|| imagenesCuadros[1] == imagenesCuadros[2] || imagenesCuadros[1] == imagenesCuadros[3]
					|| imagenesCuadros[2] == imagenesCuadros[0] || imagenesCuadros[2] == imagenesCuadros[3]) {
				// acierto += 5;
				jugador.setPuntaje();
				imagenesCuadros[4] = cuadro5.getCuadrosVisibles();
			} else if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[0] == imagenesCuadros[3] || imagenesCuadros[0] == imagenesCuadros[4]
					|| imagenesCuadros[1] == imagenesCuadros[0] || imagenesCuadros[1] == imagenesCuadros[2]
					|| imagenesCuadros[1] == imagenesCuadros[3] || imagenesCuadros[1] == imagenesCuadros[4]
					|| imagenesCuadros[2] == imagenesCuadros[3] || imagenesCuadros[2] == imagenesCuadros[4]
					|| imagenesCuadros[3] == imagenesCuadros[4]) {
				// acierto += 5;
				jugador.setPuntaje();
				imagenesCuadros[5] = cuadro6.getCuadrosVisibles();
			} else if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[0] == imagenesCuadros[3] || imagenesCuadros[0] == imagenesCuadros[4]
					|| imagenesCuadros[0] == imagenesCuadros[5] || imagenesCuadros[1] == imagenesCuadros[2]
					|| imagenesCuadros[1] == imagenesCuadros[3] || imagenesCuadros[1] == imagenesCuadros[4]
					|| imagenesCuadros[1] == imagenesCuadros[5] || imagenesCuadros[2] == imagenesCuadros[3]
					|| imagenesCuadros[2] == imagenesCuadros[4] || imagenesCuadros[2] == imagenesCuadros[5]
					|| imagenesCuadros[3] == imagenesCuadros[4] || imagenesCuadros[3] == imagenesCuadros[5]
					|| imagenesCuadros[4] == imagenesCuadros[5]) {
				// acierto += 5;
				jugador.setPuntaje();
				imagenesCuadros[6] = cuadro7.getCuadrosVisibles();
			} else if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[0] == imagenesCuadros[3] || imagenesCuadros[0] == imagenesCuadros[4]
					|| imagenesCuadros[0] == imagenesCuadros[5] || imagenesCuadros[0] == imagenesCuadros[6]
					|| imagenesCuadros[1] == imagenesCuadros[2] || imagenesCuadros[1] == imagenesCuadros[3]
					|| imagenesCuadros[1] == imagenesCuadros[4] || imagenesCuadros[1] == imagenesCuadros[5]
					|| imagenesCuadros[1] == imagenesCuadros[6] || imagenesCuadros[2] == imagenesCuadros[3]
					|| imagenesCuadros[2] == imagenesCuadros[4] || imagenesCuadros[2] == imagenesCuadros[5]
					|| imagenesCuadros[2] == imagenesCuadros[6] || imagenesCuadros[3] == imagenesCuadros[4]
					|| imagenesCuadros[3] == imagenesCuadros[5] || imagenesCuadros[3] == imagenesCuadros[6]
					|| imagenesCuadros[4] == imagenesCuadros[5] || imagenesCuadros[4] == imagenesCuadros[6]
					|| imagenesCuadros[5] == imagenesCuadros[6]) {
				// acierto += 5;
				jugador.setPuntaje();
				imagenesCuadros[7] = cuadro8.getCuadrosVisibles();
			} else if (imagenesCuadros[0] == imagenesCuadros[1] || imagenesCuadros[0] == imagenesCuadros[2]
					|| imagenesCuadros[0] == imagenesCuadros[3] || imagenesCuadros[0] == imagenesCuadros[4]
					|| imagenesCuadros[0] == imagenesCuadros[5] || imagenesCuadros[0] == imagenesCuadros[6]
					|| imagenesCuadros[0] == imagenesCuadros[7] || imagenesCuadros[1] == imagenesCuadros[2]
					|| imagenesCuadros[1] == imagenesCuadros[3] || imagenesCuadros[1] == imagenesCuadros[4]
					|| imagenesCuadros[1] == imagenesCuadros[5] || imagenesCuadros[1] == imagenesCuadros[6]
					|| imagenesCuadros[1] == imagenesCuadros[7] || imagenesCuadros[2] == imagenesCuadros[3]
					|| imagenesCuadros[2] == imagenesCuadros[4] || imagenesCuadros[2] == imagenesCuadros[5]
					|| imagenesCuadros[2] == imagenesCuadros[6] || imagenesCuadros[2] == imagenesCuadros[7]
					|| imagenesCuadros[3] == imagenesCuadros[4] || imagenesCuadros[3] == imagenesCuadros[5]
					|| imagenesCuadros[3] == imagenesCuadros[6] || imagenesCuadros[3] == imagenesCuadros[7]
					|| imagenesCuadros[4] == imagenesCuadros[5] || imagenesCuadros[4] == imagenesCuadros[6]
					|| imagenesCuadros[4] == imagenesCuadros[7] || imagenesCuadros[5] == imagenesCuadros[6]
					|| imagenesCuadros[5] == imagenesCuadros[7] || imagenesCuadros[6] == imagenesCuadros[7]) {
				// acierto += 5;
				jugador.setPuntaje();
			}

			// System.out.println("Inicio de juego en Falso.");
		}

	}
	*/


	/**
	 * se encargara especificamente de poder probar si se falla en la elección de
	 * los cuadros, si no son iguales.
	 * 
	 * @return
	 */

	/*
	public void detectarFalla() {

		while (inicioJuego == true) {

			if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]) {

				disminuirVida();
				imagenesCuadros[3] = cuadro4.getCuadrosVisibles();

			} else if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]
					|| imagenesCuadros[0] != imagenesCuadros[3]) {

				disminuirVida();
				imagenesCuadros[4] = cuadro5.getCuadrosVisibles();

			} else if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]
					|| imagenesCuadros[0] != imagenesCuadros[3] || imagenesCuadros[0] != imagenesCuadros[4]) {

				disminuirVida();
				imagenesCuadros[5] = cuadro6.getCuadrosVisibles();

			} else if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]
					|| imagenesCuadros[0] != imagenesCuadros[3] || imagenesCuadros[0] != imagenesCuadros[4]
					|| imagenesCuadros[0] != imagenesCuadros[5]) {

				disminuirVida();
				imagenesCuadros[6] = cuadro7.getCuadrosVisibles();

			} else if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]
					|| imagenesCuadros[0] != imagenesCuadros[3] || imagenesCuadros[0] != imagenesCuadros[4]
					|| imagenesCuadros[0] != imagenesCuadros[5] || imagenesCuadros[0] != imagenesCuadros[6]) {

				disminuirVida();
				imagenesCuadros[7] = cuadro8.getCuadrosVisibles();

			} else if (imagenesCuadros[0] != imagenesCuadros[1] || imagenesCuadros[0] != imagenesCuadros[2]
					|| imagenesCuadros[0] != imagenesCuadros[3] || imagenesCuadros[0] != imagenesCuadros[4]
					|| imagenesCuadros[0] != imagenesCuadros[5] || imagenesCuadros[0] != imagenesCuadros[6]
					|| imagenesCuadros[0] != imagenesCuadros[7]) {
				// acierto += 5;
				disminuirVida();
			}
		}

	}
	*/
	
	public String pedirNombreUsuario() {
		String name = JOptionPane.showInputDialog("Digite su Primer Nombre: ");
		//JOptionPane.showMessageDialog(null, "Bienvenido a Atento y Rapido " + name + "\nRecuerde estar atento y vivo a los cambios de imagenes, Feliz Juego.");
		return name;
	}


//JOption pane para mostrar el resultado de puntajes y errores.
/**
 * MostrarRondaFinal();
 * purpose: este metodo me toma el puntaje y los errores de lo que el jugador obtenga en la partida. 
 */
	public void mostrarRondaFinal() {

		// JOptionPane cuadro = new JOptionPane();
		JOptionPane.showMessageDialog(null, pedirNombreUsuario() + " El resultado Final de tú ronda es de: " + "\n- Puntaje Logrado: "
				+ devolverPuntaje() + "\n- Errores: " + devolverErrores() + "\n- Aciertos: " + devolverAcierto() + 
				"\n- Vida: " + devolverVida());
	}
	
/**
 * cambiosCuadros();
 * Purpose: este metodo se encargara de poder tomar un numero aleatorio entre el rango de cuadros dados y juntarlo 
 * a los cuadros que existen para de esa forma poder efectuar cambios de cuadros en la interfaz grafica mientras se va jugando, 
 * y de esa forma si en los cambios de cuadros efectuados llegan a haber dos iguales sencillamente se iniciará un identificador
 * dando asi la muestra de que habrán imagenes iguales.
 *  
 * Ejm: El nuevo numero que está entrando, sea diferente al numero que está "saliendo".
 */
	public void cambiosCuadros() {

		// selecionar numero random entre 0- y los numeros que hayan "posiciones".

		// int var3; //posicion que cambia.
		Random algo3 = new Random();
		var3 = algo3.nextInt(var); // posicion que va a cambiar.

		int var4; // el nuevo valor de la posicion que cambia.
		// reutilizar el cuadro1, como caso base de cuadros a cambiar.
		var4 = cuadro1.getCuadrosVisibles();
		while (imagenesCuadros[var3] == var4) {
			// el nuevo numero que entra sea igual al de salida, entonces se seguirá
			// haciendo hasta que sean diferentes entre si.
			var4 = cuadro1.getCuadrosVisibles();

		}

		if (buscarElementosV(imagenesCuadros, var4)) {

			identificadorPares = true; // se deja saber entonces que hay un par.

		}else{
			
			identificadorPares = false; //se deja saber que no es par.
		}

		// entonces si el cambio se ejecuta se hace el proceso.

		imagenesCuadros[var3] = var4; // Cambio efectuado.

	}
/*
 * pares();
 * purpose: este metodo se encargará de establecer en true el identificadorPares y si asi es es porque las imagenes son pares.
 */
	public boolean pares() {
		// cuadrosPares(); //llamando al metodo que me hace referencia a que hay cuadros
		// pares...
		identificadorPares = true;
		return identificadorPares;
	}

/*
 * impares();
 * purpose: este metodo se encargará de poner si dos imagenes son impares y asi mismo establecer el identificadorPares en false,
 * haciendo referencia a imagenes que no son iguales.
 */
	public boolean impares() {
		identificadorPares = false;
		return identificadorPares;
	}

	/**
	 * purpose: retornar un click o un noClick. 
	 * @param presionarBoton es un parametro booleano del cual si está en true es porque cuenta como click,
	 * y si está en false es porque es un noClick. 
	 * @return boolean (true v false);
	 */
	public boolean click(boolean presionarBoton) {

		return presionarBoton;
	}
	
	
	/*
	 * devolverVida();
	 * purpose: este metodo me llama al objeto jugador de la clase Player para invocar al metodo devolver vida y retornarlo. 
	 */
	public int devolverVida(){
		//clickear();
		//noClickear();
		return jugador.getVida();
	}
/*
 * devolverPuntaje(); 
 * purpose: invocar al metodo puntaje y acierto de la clase Player mediante el objeto jugador.
 * return jugador.getPuntaje();
 */
	public int devolverPuntaje() {
		//int scoreJugador = jugador.getPuntaje();
		// System.out.println("devolverPuntaje - : " + scoreJugador);

		return jugador.getPuntaje();
	}
/*
 * devolverAcierto();
 * purpose: este metodo llama el metodo de la clase Player -> getAcierto(); mediante el objeto jugador de la clase pertienente
 * y retorna el metodo mencionado. 
 * 
 */
	public int devolverAcierto() {
		//int aciertosJugador = jugador.getAcierto();
		return jugador.getAcierto();
	}

	/*
	 * devolverErrores();
	 * purpose: este metodo llama el metodo de la clase Player -> getErrores(); mediante el objeto jugador de la clase pertienente
	 * y retorna el metodo mencionado. 
	 * 
	 */
	public int devolverErrores() {
		//int erroresJugador = jugador.getErrores();
		return jugador.getErrores();
	}

	
/**
 * cuadrosPares();
 * purpose: este metodo de ratificar si hay cuadros pares llamando al identificador antes creado, en caso tal de que lo hayan,
 * se llama a los metodos setters de la clase Player que lo que haran sera establecer los puntajes y los aciertos.
 * return -> is void method.
 */
	public void cuadrosPares() {
		// si se efectua el cambio del metodo cambiøsCuadrøs se sabe que hay par y pør
		// lo tanto se hara proceso menos dispendioso.

		if (identificadorPares) {
			// mirar la condicion de si el boton fue o no presionado. - incluir este metodo
			// dentro de las 4 condiciones 'match,press'.
			jugador.setPuntaje(); // los aciertos, se sumara el puntaje de 5 en 5.
			jugador.setAcierto(); // se sumaran aciertos del jugador cada vez que gane.

			// devolverPuntaje();

		}
	}
	
	/**
	 * @Autor: Juan Felipe Osorio Zapata. 
	 * sDate: 11/03/2021. 
	 * Purpose: clickear(); && noClickear(); -> este metodo consistirá basicamente en llevar el proceso 
	 * condiciones necesarias dentro del juego para que se tomen en cuenta
	 * los procesos de SCORE,ACIERTOS, Y FALLAS, VIDA del jugador, y
	 * sucesivamente si pierde todas las vidas GAME OVER, y con los demas
	 * caracteristicas lo mismo dentro de lo que le toca a cada uno.
	 * Example: imagenesPares && pressBOTON --> al mismo tiempo... return
	 * Score +5 && Acierto +1;
	 */

	public void noClickear() {
		// boolean condicion = true;

		//cuadrosPares();
		if (impares() && presionarBoton == false) {

			System.out.println("NO HAY IMAGEN PAR PERO SI CLICK");
			System.out.println("click");
			jugador.setPuntaje();
			jugador.setAcierto();

			// regla -> si hay imagen par pero no hay un presionarBoton

		} else if (identificadorPares && presionarBoton == false) {

			System.out.println("NO HAY IMAGEN PAR PERO SI CLICK");
			System.out.println("click");
			System.out.println("no click");
			jugador.disminuirVida();
			jugador.setErrores();
		}

	}

	public void clickear() {
		// regla primordial del juego - si no hay imagen par pero si se presiona el
		// boton -> - 1 vida.
		//cuadrosPares();
		if (impares() && presionarBoton == true) {
			System.out.println("NO HAY IMAGEN PAR PERO SI CLICK");
			System.out.println("click");

			jugador.disminuirVida(); // darle la condicion a la disminuir para que con cada click no se disminuya la
										// vida.
			jugador.setErrores();
			
		} else if (identificadorPares && presionarBoton == true) {

			System.out.println("NO HAY IMAGEN PAR PERO SI CLICK");
			System.out.println("click");
			jugador.setPuntaje();
			jugador.setAcierto();
		}

	}


} // llave de la clase padre controlCuadros.

/**
 * 
 */
package LogicaAtentoR;

/**
 * @author Felipe
 * la clase Player se llamará en el controlador del cuadro que lo que hará
 * será poder crear un objeto de tipo player para llamar los metodos que se crearán aqui en los metodo del controlador
 * respectivos a los aciertos y vidas del jugador. 
 */
public class Player {
	
	private int puntaje;
	//es la vida por defecto que tendrá el jugador al empezar el juego. 
	private int vidas = 3;
	//añadir un atributo llamado error, para poder contar los errores.
	private int errores = 0;
	private int aciertos = 0;
	//private ControlCuadro control;
	
	
	/**
	 * setPuntaje();
	 * purpose: se establece un puntaje en + 5 cada vez que se invoce demás procesos en la clase controladora. 
	 * 
	 */
	public void setPuntaje() {
		this.puntaje += 5;
		//System.out.println("setPuntaje - score: " + puntaje);
	}
	/**
	 * getPuntaje();
	 * purpose: se retornará el puntaje dado del jugador de lo que haya logrado en su partida.
	 * @return puntaje;
	 * 
	 */
	public int getPuntaje(){
		setPuntaje();
		System.out.println("getPuntaje - score: " + puntaje);
		return puntaje;
	}
	
	/**
	 * SetVida(); --> se encargará exclsivamente de restar vida, en caso tal de que se cumplan las condiciones 
	 * que estan dadas en el controlador. 
	 */
	public void disminuirVida() {
		//se efectuara el proceso siempre y cuando la condicion que tengo en mi controlador se cumpla, entonces se
		//restarán menos 1 vida en las totales del jugador.
		
		this.vidas -= 1; // de 3 que tenia ahora tengo solo 2, y asi sucesivamente conforme las veces que se llame el metodo.
		System.out.println("Ojo, tiene este numero de vidas: " + vidas);
		
		if(vidas == 0) {
			System.out.println("No hay más vida, puedes reiniciar el juego, game over. ");
			System.exit(0); //fin del juego en pocas palabras, Las vidas se acaban -> el juego se acaba. 
		}
	}
	
	/**
	 * GetVida(); --> se encargara del proceso final cuando tenga que retornar la vida; 
	 * @return vida;
	 */
	public int getVida() {
		return vidas;
	}
	
/**
 * setAcierto(); 
 * purpose: se tomará un acierto cada vez que se logré un puntaje.
 */
	public void setAcierto(){
		this.aciertos += 1; 
	}
	
/**
 * getAcierto();
 * purpose: se retornará el acierto del jugador. 	
 * @return aciertos;
 */
	public int getAcierto(){
		setAcierto();
		return aciertos;
	}
	
/**
 * setErrores(); 
 * purpose: se encargará de establecer lo errores dependiendo de las condiciones que se den en los metodos de la clase controladora.
 * 
 */
	public void setErrores(){
		this.errores += 1;
		System.out.println("numero de errores: " + errores);
	}
	
	/**
	 * GetErrores(); --> me permitirá tomar los errores de la partida del jugador. 
	 * @return errores;
	 */
	
	public int getErrores(){
		setErrores();
		return errores;
	}
	
}
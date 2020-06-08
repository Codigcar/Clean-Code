
import java.util.concurrent.ThreadLocalRandom;

class Helper {
	//nombre de clases(sustantivos) es UpperCase
	//nombre de metodos(verbo) es lowerCase
	//nombre de atributos(caracteristica) es lowerCase
	//no hay snake_case en Java
	static int[] generarArrayAleatorio ( int cantidad ) {
		int [] array = new int[cantidad];
		for ( int n =0; n<cantidad;n++ ) {
			array[n] = ThreadLocalRandom.current().nextInt(0, 100000 + 1);
		} 
		return array;
	}

}

/**
 * 
 * @author USUARIOS
 *
 * #Requisitos funcionales:
 * - El valor del nodo no puede ser modificado
 * - Cuando se inserte un nuevo nodo, se inserte al final
 * 
 * # Modificaciones
 * - Cambio de nombre de atributos: The principle of least Surprise
 * - Cambio de lógica de negocio (basica) : The boy Scout Rule
 * - Verificando que los métodos cumplan con el principio: Single Responsability Principle
 */

class ListaEnlazada {
	
	// Nodo Inicial
	private Nodo primero;
	// Nodo Final
	private Nodo ultimo;

	// Constructor de la clase
	public ListaEnlazada () {
		this.primero = null;
		this.ultimo = null;
		System.out.println("Soy lista enlazada : 1.0");
	}

	// Crea la lista a partir de un arreglo de valores
	public int crearSimple ( int[] valores ) {
		// por cada elemento del arreglo crea un nodo
		for (int valor : valores) {
			// Nuevo objeto nodo
			Nodo nuevoNodo = new Nodo( valor );
			
			if ( this.primero == null ) {
				// Si la lista esta vacia, crea una nueva
				this.primero = nuevoNodo;
				this.ultimo = nuevoNodo;
			} 
			//Si la lista NO está vacia, entonces el ultimo nodo apunta al nuevo nodo
			else {
				this.ultimo.setSiguiente( nuevoNodo );
				// El nuevo nodo toma la posicion del ultimo elemento en las variables
				this.ultimo = nuevoNodo;
			}
		}
		
		return getCantidad();
	}

	public int getCantidad() {
		int cantidad = 0;
		Nodo nodo = this.primero;
		while( nodo != null ) {
			cantidad++;
			nodo = nodo.getSiguiente();
		}
		return cantidad;
	}
	
	
	// retorna la lista de forma ordenada
	public void mostrarLista () {
		Nodo nodo = this.primero;
		while ( nodo != null ) {
			System.out.println( nodo.getValor() );
			nodo = nodo.getSiguiente();
		} 
	}

}

// Objeto Nodo de la lista
class Nodo {
	private int valor;
	// Verificar que un objeto este instanciado
	// Puede generar un NullPointException
	// Cuando crees un objeto debe igualarse a un valor inicial o null
	private Nodo siguiente;
	
	public Nodo ( int valor ) {
		this.valor = valor;
		this.siguiente = null;
	}
	public void setSiguiente (Nodo siguiente) {
		this.siguiente = siguiente;
	}
	public int getValor () {
		return this.valor;
	}
	public Nodo getSiguiente () {
		return this.siguiente;
	}
}

class Main {
	  public static void main(String[] args) {
	    
		// Arreglo generico
		int[] arregloBase = Helper.generarArrayAleatorio(20);

		// Ejecución de la lista enlazada simple
		ListaEnlazada lista = new ListaEnlazada();
		lista.crearSimple( arregloBase );
		lista.mostrarLista();

	  }
	}
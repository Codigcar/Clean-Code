
import java.util.concurrent.ThreadLocalRandom;

class Helper {

	static int[] lista_generica_valores ( int largo_cadena ) {
		int [] arreglo_base = new int[largo_cadena];
		for ( int n =0; n<largo_cadena;n++ ) {
			arreglo_base[n] = ThreadLocalRandom.current().nextInt(0, 100000 + 1);
		} 
		return arreglo_base;
	}

}
class ListaEnlazada {
	
	// Nodo Inicial
	private Nodo inicio;
	// Nodo Final
	private Nodo fin;

	// Constructor de la clase
	public ListaEnlazada () {
		this.inicio = null;
		this.fin = null;
		System.out.println("Soy lista enlazada : 1.0");
	}

	// Crea la lista a partir de un arreglo de valores
	public void crearSimple ( int[] valores ) {
		// por cada elemento del arreglo crea un nodo
		for (int n : valores) {
			// Nuevo objeto nodo
			Nodo nuevoNodo = new Nodo( n );
			
			if ( this.inicio == null ) {
				// Si la lista esta vacia, crea una nueva
				this.inicio = nuevoNodo;
				this.fin = nuevoNodo;
			} else {
				// Si la lista existe el ultimo elemento es apuntado al nuevo nodo
				this.fin.setSiguiente( nuevoNodo );
				// El nuevo nodo toma la posicion del ultimo elemento en las variables
				this.fin = nuevoNodo;
			}
		}
	}

	// retorna la lista de forma ordenada
	public void retornaLista () {
		Nodo recorre = this.inicio;
		while ( recorre != null ) {
			System.out.println( recorre.getValor() );
			recorre = recorre.getSiguiente();
		} 
	}

}

// Objeto Nodo de la lista
class Nodo {
	private int valor;
	private Nodo siguiente;
	public Nodo ( int valor ) {
		this.valor = valor;
	}
	public void setSiguiente (Nodo sig) {
		this.siguiente = sig;
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
		int[] arreglo_base = Helper.lista_generica_valores(20);

		// Ejecución de la lista enlazada simple
		ListaEnlazada lista = new ListaEnlazada();
		lista.crearSimple( arreglo_base );
		lista.retornaLista();

	  }
	}

public class Controlador {

	private Vista vista;
	private Modelo modelo;
	
	public static void main(String[] args) {
		
		new Controlador();

	}
	
	public Controlador(){
		
		this.vista=new Vista(this);
		this.modelo=new Modelo();
		
	}

	public void a�adirJugador(String nombre) {

		this.modelo.a�adirJugador(nombre);
		
	}
	
	public void eliminarJugador(String nombre) {

		this.modelo.eliminarJugador(nombre);
		
	}

	public Modelo getModelo() {
		return modelo;
	}
	
	

}

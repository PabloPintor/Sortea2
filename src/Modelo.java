import java.util.Arrays;

public class Modelo {

	private String[] listaJugadores=new String[30];
	private int nJug=0;
	

	public void añadirJugador(String nombre) {
		
		listaJugadores[nJug]=nombre;
		nJug++;
		
		
	}
	
	public void eliminarJugador(String nombre) {
		
		this.listaJugadores[nJug]=nombre;
		nJug--;
		
	}
	

	public String[] getListaJugadores() {
		return listaJugadores;
	}

	public int getnJug() {
		return nJug;
	}

	public void setnJug(int nJug) {
		this.nJug = nJug;
	}
	
	
	
	

}
	
	
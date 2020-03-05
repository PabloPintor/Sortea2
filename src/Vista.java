import java.awt.Window;
import java.util.Random;

import javax.swing.JOptionPane;

public class Vista {

	private Controlador controlador;
	private VentanaPpal ventanaPpal;
	private Vista vista;
	private DialogoAñadir dialogoAñadir;
	private Modelo modelo;


	public Vista (Controlador controlador) {

		this.controlador=controlador;
		this.ventanaPpal=new VentanaPpal(this);
		this.dialogoAñadir=new DialogoAñadir(this);

		this.ventanaPpal.setVisible(true);



	}


	public void abrirDialogoAñadir() {

		this.dialogoAñadir.setVisible(true);

	}

	public void error(Window padre, String msg)
	{
		JOptionPane.showMessageDialog(padre, msg, "Error",  JOptionPane.ERROR_MESSAGE);
	}

	public void msg(Window padre, String msg)
	{
		JOptionPane.showMessageDialog(padre, msg, "Correcto",  JOptionPane.INFORMATION_MESSAGE);
	}


	public void añadirJugador(String nombre) {

		this.controlador.añadirJugador(nombre);

	}

	public void eliminarJugador(String nombre) {

		this.controlador.eliminarJugador(nombre);

	}

	public void actualizarListaJugadores() {

		this.ventanaPpal.actualizarListaJugadores(this.controlador.getModelo().getListaJugadores(), this.controlador.getModelo().getnJug());

	}


	public String sortear(String numero) {

		int numVeces=Integer.parseInt(numero);

		String listaSortear[]=new String[this.controlador.getModelo().getnJug()];
		String premiados="";
		int premiado;

		Random rand=new Random();

		for (int i = 0; i < listaSortear.length; i++) {
			listaSortear[i]=this.controlador.getModelo().getListaJugadores()[i];
		}

		int posicion=0;
		
		boolean entrar=true;
		
		if (numVeces>listaSortear.length) {
			JOptionPane.showMessageDialog(null, "El numero de premios debe ser menor que el numero de participantes", "Correcto",  JOptionPane.INFORMATION_MESSAGE);
			entrar=false;
		}
		
		while (posicion<numVeces && entrar==true) {

			premiado=rand.nextInt(this.controlador.getModelo().getnJug());

			if (listaSortear[premiado]!=null) {

				premiados+=listaSortear[premiado]+"\n";
				listaSortear[premiado]=null;
				posicion++;
			}


		}
		
		return premiados;

	}


	public String HacerEquipos(String numero) {

		int numVeces=Integer.parseInt(numero);

		String listaSortear[]=new String[this.controlador.getModelo().getnJug()];
		String premiados="";
		int premiado;

		int seed=new Random().nextInt(1000);
		Random rand=new Random(seed);
		rand.setSeed(seed);

		for (int i = 0; i < listaSortear.length; i++) {
			listaSortear[i]=this.controlador.getModelo().getListaJugadores()[i];
		}

		for (int i = 0; i < listaSortear.length/numVeces; i++) {

			int numeroEquipo=i+1;

			premiados+="Equipo "+numeroEquipo+":\n";


			int posicion=0;
			while (posicion<numVeces) {

				premiado=rand.nextInt(this.controlador.getModelo().getnJug());

				if (listaSortear[premiado]!=null) {

					premiados+="      "+listaSortear[premiado]+"\n";
					listaSortear[premiado]=null;
					posicion++;
				}


			}

			premiados+="\n";

		}



		boolean hay=false;
		for (int j = 0; j < listaSortear.length; j++) {

			if (listaSortear[j]!=null) {
				
				if (!hay) {
					premiados+="Sobran:\n";
					hay=true;
				}
				
				premiados+="      "+listaSortear[j]+"\n";
			}


		}

		return premiados;

	}


	public boolean comprobarJugadores() {
		
		return this.controlador.getModelo().getnJug()!=0;
		
	}




}

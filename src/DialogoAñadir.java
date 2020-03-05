import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogoA�adir extends JDialog {

	private Vista vista;
	private JTextField campoA�adirJugador;
	
	public DialogoA�adir(Vista vista) {
		setResizable(false);
		setTitle("A\u00F1adir jugador");
		
		this.vista=vista;
		
		
		setBounds(100, 100, 262, 137);
		
		campoA�adirJugador = new JTextField();
		campoA�adirJugador.setColumns(10);
		
		JLabel lblJugador = new JLabel("Jugador:");
		
		JButton botonA�adirJugador = new JButton("A\u00F1adir");
		botonA�adirJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonA�adirPulsado();
				
			}
		});
		
		JButton botonCerrar = new JButton("Cerrar");
		botonCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonCerrarPulsado();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblJugador, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(campoA�adirJugador, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(botonA�adirJugador, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoA�adirJugador, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblJugador, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(botonA�adirJugador, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(botonCerrar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void botonCerrarPulsado() {
		
		this.setVisible(false);
		
	}

	protected void botonA�adirPulsado() {
		
		String nombre=this.campoA�adirJugador.getText();
		
		if (this.campoA�adirJugador.getText().isEmpty()) {
			vista.error(this,"El campo debe tener un jugador!");
		}
		else {
			this.vista.a�adirJugador(nombre);
			vista.msg(this, "Jugador a�adido!");
			
			vista.actualizarListaJugadores();
			
			this.campoA�adirJugador.setText("");
			
		}
		
	}

}

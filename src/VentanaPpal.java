import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Point;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private JTextField campoNumeroPremios;
	
	private Vista vista;
	
	private JTextPane listaParticipantes;
	private JTextPane listaPremiados;

	/**
	 * Create the frame.
	 */
	public VentanaPpal(Vista vista) {
		
		this.vista=vista;
		
		
		setResizable(false);
		setTitle("SORTEA2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton botonSortear = new JButton("Sortear");
		botonSortear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonSortearPulsado();
				
			}
		});

		
		JLabel lblNPremios = new JLabel("N\u00BA Premios");
		
		campoNumeroPremios = new JTextField();
		campoNumeroPremios.setColumns(10);
		
		JButton botonAñadir = new JButton("A\u00F1adir");
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				abrirDialogoAñadir();
				
			}
		});
		
		JLabel lblParticipantes = new JLabel("Participantes");
		
		JLabel lblPremiados = new JLabel("Premiados");
		
		JButton botonHacerEquipos = new JButton("Hacer equipos");
		botonHacerEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				botonHacerEquiposPulsado();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(botonHacerEquipos, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(botonAñadir, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNPremios)
									.addGap(18)
									.addComponent(campoNumeroPremios, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
								.addComponent(botonSortear, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
							.addGap(18))
						.addComponent(lblParticipantes))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPremiados, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(lblPremiados)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(botonAñadir, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNPremios)
										.addComponent(campoNumeroPremios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(botonSortear, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(botonHacerEquipos, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
									.addGap(21))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblParticipantes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		listaPremiados = new JTextPane();
		scrollPane_1.setViewportView(listaPremiados);
		
		listaParticipantes = new JTextPane();
		listaParticipantes.setEditable(false);
		scrollPane.setViewportView(listaParticipantes);
		contentPane.setLayout(gl_contentPane);
	}

	protected void botonHacerEquiposPulsado() {
		
		if (comprobarCampos()) {
			this.listaPremiados.setText(vista.HacerEquipos(this.campoNumeroPremios.getText()));
		}
		else {
			vista.msg(this, "Tienen que haber participantes y numero de premios!");
		}
		
	}

	private boolean comprobarCampos() {
		
		if (this.campoNumeroPremios.getText().isEmpty()) {
			return false;
		}
		if (!this.vista.comprobarJugadores()) {
			return false;
		}
		
		return true;
	}

	protected void botonSortearPulsado() {
		
		if (comprobarCampos()) {
			this.listaPremiados.setText(vista.sortear(this.campoNumeroPremios.getText()));
		}
		else {
			vista.msg(this, "Tienen que haber participantes y numero de premios!");
		}
		
	}

	protected void abrirDialogoAñadir() {
		vista.abrirDialogoAñadir();
		
	}

	public void actualizarListaJugadores(String[] lista, int numeroJug) {

		String res="";
		
		for (int i = 0; i < numeroJug; i++) {
			res+=lista[i]+"\n";
		}
		
		listaParticipantes.setText(res);
		
	}
}

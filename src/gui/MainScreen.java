package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainScreen extends JPanel implements GameState, ActionListener {

	private TetrisGUI root;
	private JButton botonIniciar, botonCargar, botonSalir;

	public MainScreen(TetrisGUI root) {
		this.root = root;

		setLayout(new FlowLayout());
		initialize();
	}

	private void initialize() {

		botonIniciar = new JButton("Iniciar");
		botonCargar = new JButton("Cargar");
		botonSalir = new JButton("Salir");

		botonIniciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Iniciando...");
			}
		});

		botonCargar.addActionListener(this);

		add(botonIniciar);
		add(botonCargar);
		add(botonSalir);
	}

	@Override
	public void enter() {
		this.root.setContentPane(this);

	}

	@Override
	public void exit() {
		this.root.remove(this);
		this.root.revalidate();
		this.root.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == botonCargar) {
			this.exit();
			System.out.println("Cerrar");
		}

	}

}

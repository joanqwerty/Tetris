package gui;

import javax.swing.JFrame;

public class TetrisGUI extends JFrame {

	private MainScreen mainScreen;
	private GameState currentState;

	TetrisGUI() {
		mainScreen = new MainScreen(this);
	}

	void initialize() {
		setState(mainScreen);
	}

	void setState(GameState state) {

		if (currentState != null) {
			currentState.exit();
		}

		currentState = state;
		currentState.enter();
		revalidate();
		repaint();
	}

	public void start() {
		this.setTitle("Tetris");
		this.setSize(600, 600);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initialize();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TetrisGUI().start();
	}

}

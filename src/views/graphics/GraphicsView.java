package views.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import views.View;

public class GraphicsView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 550;

	private GameView gameView;

	public GraphicsView() {
		gameView = new GameView();
		gameView.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(gameView);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void interact() {
		setVisible(true);
		gameView.start();
	}

}

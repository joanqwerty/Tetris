package view.graphics;

import controllers.MoveController;
import models.Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameView extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private boolean isRunning = true;

	private BoardView boardView;
	private BlockView blockView;

	private MoveController moveController;

	private Game game;

	public GameView() {
		init();
	}

	private void init() {
		game = new Game();
		moveController = new MoveController(game);
		boardView = new BoardView(moveController);
		blockView = new BlockView(moveController);
	}

	public void start() {
		new Thread(this).start();
	}

	private void inputHandler() {
		addKeyListener(new InputHandler(moveController));
	}

	@Override
	public void run() {
		inputHandler();

		while (isRunning) {
			if (moveController.isGameOver()) {
				moveController.reset();
			}
			render();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		setBackground(new Color(20, 20, 20));
		g.fillRect(0, 0, getWidth(), getHeight());

		blockView.render(g);
		boardView.render(g);

		g.dispose();
		bs.show();

	}
}
package views.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import controllers.GameController;
import models.Game;

public class GameView extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	private boolean isRunning = true;

	public static final int FPS = 60;

	private BoardView boardView;
	private BlockView blockView;

	private GameController moveController;

	private Game game;

	public GameView() {
		init();
	}

	private void init() {
		game = new Game();
		moveController = new GameController(game);
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

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (isRunning) {

			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += currentTime - lastTime;

			lastTime = currentTime;

			if (delta >= 1) {
				update();
				render();
				delta--;
				drawCount++;
			}

			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
	}

	public void update() {
		if (moveController.isGameOver()) {
			moveController.reset();
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
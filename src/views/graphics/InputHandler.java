package views.graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controllers.MoveController;

public class InputHandler implements KeyListener {

	MoveController moveController;

	public InputHandler(MoveController moveController) {
		this.moveController = moveController;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		System.out.println(event.getKeyCode());

		switch (event.getKeyCode()) {
		case 87:
			moveController.rotate();
			break;
		case 83:
			moveController.moveDown();
			break;
		case 65:
			moveController.moveLeft();
			break;

		case 68:
			moveController.moveRigth();
			break;
		case 27:
			break;
		case 10:
			moveController.createBlock();
			break;
		case 32:
			moveController.reset();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}

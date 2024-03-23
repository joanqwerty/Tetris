import views.View;

public abstract class Tetris {

	protected View view;

	protected Tetris() {
		view = createView();
	}

	protected abstract View createView();

	public void play() {
		view.interact();
	}
}

import view.View;
import view.graphics.GraphicsView;

public class StandAloneGraphicsTetris extends Tetris {

	@Override
	protected View createView() {
		return new GraphicsView();
	}

	public static void main(String[] args) {
		new StandAloneGraphicsTetris().play();
	}

}

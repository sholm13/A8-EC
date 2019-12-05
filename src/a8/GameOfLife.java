package a8;

import javax.swing.JFrame;

public class GameOfLife {

	public static void main(String[] args) {
		LifeModel model = new LifeModel(20, 20, 3, 2, 3, 3);
		LifeView view = new LifeView();
		LifeController controller = new LifeController(model, view);
		view.addController(controller);
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game of Life");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		main_frame.setContentPane(view);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}

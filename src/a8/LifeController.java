package a8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;




public class LifeController {

	LifeModel model;
	LifeView view;

	boolean start_of_number;
	boolean point_pressed;


	public LifeController(LifeModel model, LifeView view) {
		this.model = model;
		this.view = view;
	}

	public void updateView() {
		view.show(model.getBoard());
	}

	public void spotClicked(int x, int y, int z) {
		model.setSpot(x, y, z);
	}

	public void run(int[][] board, int width, int height, int upper_birth_thresh, int lower_birth_thresh, 
			int upper_survive_thresh, int lower_survive_thresh) {

		int[][] temp = new int[width][height];

		for (int i = 0; i < width; i++) {

			for (int j = 0; j < height; j++) {

				int counter = 0;

				if (i-1 > -1 && j-1 > -1 && board[i-1][j-1] == 1) {

					counter++;

				}

				if (i-1 > -1 && board[i-1][j] == 1) {

					counter++;

				}

				if (i-1 > -1 && j+1 < height && board[i-1][j+1] == 1) {

					counter++;

				}

				if (j-1 > -1 && board[i][j-1] == 1) {

					counter++;

				}

				if (j+1 < height && board[i][j+1] == 1) {

					counter++;

				}

				if (i+1 < width && j-1 > -1 && board[i+1][j-1] == 1) {

					counter++;

				}

				if (i+1 < width && board[i+1][j] == 1) {

					counter++;

				}

				if (i+1 < width && j+1 < height && board[i+1][j+1] == 1) {

					counter++;

				}

				if (board[i][j] == 0) {

					if (counter < lower_birth_thresh) {

						temp[i][j] = 0;

					} else if (counter > upper_birth_thresh) {

						temp[i][j] = 0;

					} else {

						temp[i][j] = 1;

					}

				} else {

					if (counter < lower_survive_thresh) {

						temp[i][j] = 0;

					} else if (counter > upper_survive_thresh) {

						temp[i][j] = 0;

					} else {

						temp[i][j] = 1;

					}

				}

			}

		}

		model.setBoard(temp);

		view.show(model.getBoard());

	}
	
	//	public void run(int[][] board, int width, int height, 
	//			int upper_birth_thresh, int lower_birth_thresh, 
	//			int upper_survive_thresh, int lower_survive_thresh){
	//
	//
	//		int [][] temp = new int[board.length][board[0].length];
	//		int counter = 0;
	//		for (int i = 0; i < board.length; i++) {
	//			for (int j = 0; j < board[0].length; j++) {
	//
	//				// torus diagonal bottom right corner
	////				if (i == board.length - 1 && j == board[0].length - 1) {
	////					if (board[0][0] == 1) {
	////						counter ++;
	////					}
	////				}
	//				// torus diagonal bottom left corner
	////				if (i == 0 && j == board[0].length - 1) {
	////					if (board[board.length - 1][0] == 1) {
	////						counter ++;
	////					}
	////				}
	//				// torus diagonal top right corner
	////				if (i == 0 && j == 0) {
	////					if (board[board.length - 1][board[0].length - 1] == 1) {
	////						counter ++;
	////					}
	////				}
	//				// torus diagonal top left corner
	////				if (i == board.length - 1 && j == 0) {
	////					if (board[0][board[0].length - 1] == 1) {
	////						counter ++;
	////					}
	////				}
	//				// Non-torus checks
	////				if ((i-1 >=0 && j-1 >= 0) && board[i-1][j-1] == 1) {
	////					counter ++;
	////				}
	////				
	////				if (( j-1 >= 0) && board[i][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j-1 >= 0) && board[i+1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0) && board[i-1][j] == 1) {
	////					counter ++;
	////				}
	////				
	////				if ((i+1 <= board.length - 1) && board[i+1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0 && j+1 <= board[0].length - 1) && board[i-1][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((j+1 <= board[0].length - 1) && board[i][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j+1 <= board[0].length - 1) && board[i+1][j+1] == 1) {
	////					counter ++;
	////				}
	//
	//				
	//				
	//				
	//				
	//				
	//				// i - 1 torus
	////				if ((i-1 < 0 && j-1 >= 0) && board[board.length - 1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if (( j-1 >= 0) && board[i][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j-1 >= 0) && board[i+1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 < 0) && board[board.length - 1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1) && board[i+1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 < 0 && j+1 <= board[0].length - 1) && board[board.length - 1][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((j+1 <= board[0].length - 1) && board[i][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j+1 <= board[0].length - 1) && board[i+1][j+1] == 1) {
	////					counter ++;
	////				}
	////
	////				// i + 1 torus checks
	////				if ((i-1 >=0 && j-1 >= 0) && board[i-1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if (( j-1 >= 0) && board[i][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1 && j-1 >= 0) && board[0][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0) && board[i-1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1) && board[0][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0 && j+1 <= board[0].length - 1) && board[i-1][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((j+1 <= board[0].length - 1) && board[i][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1 && j+1 <= board[0].length - 1) && board[0][j+1] == 1) {
	////					counter ++;
	////				}
	////
	////				// j - 1 torus checks
	////				if ((i-1 >=0 && j-1 < 0) && board[i-1][board[0].length - 1] == 1) {
	////					counter ++;
	////				}
	////				if (( j-1 < 0) && board[i][board[0].length - 1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1 && j-1 < 0) && board[0][board[0].length - 1] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0) && board[i-1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1) && board[0][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0 && j+1 <= board[0].length - 1) && board[i-1][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((j+1 <= board[0].length - 1) && board[i][j+1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 > board.length - 1 && j+1 <= board[0].length - 1) && board[0][j+1] == 1) {
	////					counter ++;
	////				}
	////
	////				// j + 1 torus checks
	////				if ((i-1 >=0 && j-1 >= 0) && board[i-1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if (( j-1 >= 0) && board[i][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j-1 >= 0) && board[i+1][j-1] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0) && board[i-1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1) && board[i+1][j] == 1) {
	////					counter ++;
	////				}
	////				if ((i-1 >= 0 && j+1 > board[0].length - 1) && board[i-1][0] == 1) {
	////					counter ++;
	////				}
	////				if ((j+1 > board[0].length - 1) && board[i][0] == 1) {
	////					counter ++;
	////				}
	////				if ((i+1 <= board.length - 1 && j+1 > board[0].length - 1) && board[i+1][0] == 1) {
	////					counter ++;
	////				}
	////
	//
	//				if (board[i][j] == 0) {
	//
	//                    if (counter < lower_birth_thresh) {
	//
	//                          temp[i][j] = 0;
	//
	//                    } else if (counter > upper_birth_thresh) {
	//
	//                          temp[i][j] = 0;
	//
	//                    } else {
	//
	//                          temp[i][j] = 1;
	//
	//                    }
	//
	//             } else {
	//
	//                    if (counter < lower_survive_thresh) {
	//
	//                          temp[i][j] = 0;
	//
	//                    } else if (counter > upper_survive_thresh) {
	//
	//                          temp[i][j] = 0;
	//
	//                    } else {
	//
	//                          temp[i][j] = 1;
	//
	//                    }
	//
	//             }
	//
	////				// Die from overpop or less than min neighbors
	////				if (board[i][j] == 1) {
	////					if (counter > upper_survive_thresh) {
	////						temp[i][j] = 0;
	////					}
	////					else if (counter < lower_survive_thresh) {
	////						temp[i][j] = 0;
	////					}
	////					else {
	////						temp[i][j] = 1;
	////					}
	////				}
	////					// New births
	////				if (board[i][j] == 0) {
	////					
	////					if (counter < lower_birth_thresh) {
	////						temp[i][j] = 0;
	////					}
	////					else if (counter > upper_birth_thresh) {
	////						temp[i][j] = 0;
	////					}
	////					else {
	////						temp[i][j] = 1;
	////					}
	////				}
	//
	//			}
	//		}
	//		model.setBoard(temp);
	//		view.show(model.getBoard());
	//	}

	public void action(LifeViewEvent e) {
		if (e.isClearEvent()) {
			int [][] temp = new int[model.getWidth()][model.getHeight()];

			for (int i = 0; i < model.getWidth(); i++) {
				for (int j = 0; j < model.getHeight(); j++) {
					temp[i][j] = 0;
				}
			}
			model.setBoard(temp);
			view.show(temp);
		} 
		else if (e.isRunEvent()) {
			run(model.getBoard(), model.getWidth(), model.getHeight(), 
					model.getUpperBirthThresh(), model.getLowerBirthThresh(), 
					model.getUpperSurviveThresh(), model.getLowerSurviveThresh());

		}			
		else if (e.isRandomEvent()) {
			int [][] temp = new int[model.getWidth()][model.getHeight()];

			for (int i = 0; i < model.getWidth(); i++) {
				for (int j = 0; j < model.getHeight(); j++) {
					temp[i][j] = new Random().nextInt(2);
				}
			}
			model.setBoard(temp);
			view.show(temp);

		}
		else if (e.isTorusEvent()) {

		}



	}
}




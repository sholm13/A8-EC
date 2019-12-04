package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LifeView extends JPanel implements ActionListener, SpotListener, ChangeListener {
	private JSpotBoard board;
	private JButton run_button;
	private JButton clear_button;
	private JButton random_button;
	private JSlider height_slider;
	private JSlider width_slider;
	private JSlider low_survive_slider;
	private JSlider high_survive_slider;
	private JSlider low_birth_slider;
	private JSlider high_birth_slider;
	private LifeController controller;
	
	public LifeView(int width, int height) {
		this.board = new JSpotBoard(width, height);
		board.addSpotListener(this);
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);		
		JPanel reset_message_panel = new JPanel();
		reset_message_panel.setLayout(new BorderLayout());
		this.run_button = new JButton("Run");
		this.clear_button = new JButton("Clear");
		this.random_button = new JButton("Fill RAndomly");
		
		this.height_slider = new JSlider();
		JLabel height_label = new JLabel("Height");
		this.width_slider = new JSlider();
		JLabel width_label = new JLabel("Width");
		this.low_survive_slider = new JSlider();
		JLabel low_survive_label = new JLabel("Low Survive Threshold");
		this.high_survive_slider = new JSlider();
		JLabel high_survive_label = new JLabel("High Survive Threshold");
		this.low_birth_slider = new JSlider();
		JLabel low_birth_label = new JLabel("Low Birth Threshold");
		this.high_birth_slider = new JSlider();
		JLabel high_birth_label = new JLabel("High Birth Threshold");
		
		height_slider.addChangeListener(this);
		width_slider.addChangeListener(this);
		low_survive_slider.addChangeListener(this);
		high_survive_slider.addChangeListener(this);
		low_birth_slider.addChangeListener(this);
		high_birth_slider.addChangeListener(this);
		
		JPanel info_panel_one = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(height_label, BorderLayout.WEST);
		info_panel_one.add(width_label, BorderLayout.EAST);
		add(info_panel_one, BorderLayout.NORTH);
		
		JPanel info_panel_two = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(height_slider, BorderLayout.WEST);
		info_panel_one.add(width_slider, BorderLayout.EAST);
		add(info_panel_two, BorderLayout.NORTH);
		
		JPanel info_panel_three = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(low_survive_label, BorderLayout.WEST);
		info_panel_one.add(high_survive_label, BorderLayout.EAST);
		add(info_panel_three, BorderLayout.NORTH);
		
		JPanel info_panel_four = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(low_survive_slider, BorderLayout.WEST);
		info_panel_one.add(high_survive_slider, BorderLayout.EAST);
		add(info_panel_four, BorderLayout.NORTH);
		
		JPanel info_panel_five = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(low_birth_label, BorderLayout.WEST);
		info_panel_one.add(high_birth_label, BorderLayout.EAST);
		add(info_panel_five, BorderLayout.NORTH);
		
		JPanel info_panel_six = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(low_birth_slider, BorderLayout.WEST);
		info_panel_one.add(high_birth_slider, BorderLayout.EAST);
		add(info_panel_six, BorderLayout.NORTH);
		
		run_button.addActionListener(this);
		clear_button.addActionListener(this);
		random_button.addActionListener(this);
		reset_message_panel.add(run_button, BorderLayout.CENTER);
		reset_message_panel.add(clear_button, BorderLayout.WEST);
		reset_message_panel.add(random_button, BorderLayout.EAST);
		add(reset_message_panel, BorderLayout.SOUTH);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board.getSpotAt(i, j).setBackground(Color.WHITE);
			}
		}
	}
	
	public LifeView() {
		this.board = new JSpotBoard(20, 20);
		board.addSpotListener(this);
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);		
		JPanel reset_message_panel = new JPanel();
		reset_message_panel.setLayout(new BorderLayout());
		this.run_button = new JButton("Run");
		this.clear_button = new JButton("Clear");
		this.random_button = new JButton("Fill Randomly");
		run_button.addActionListener(this);
		clear_button.addActionListener(this);
		random_button.addActionListener(this);
		
		this.height_slider = new JSlider();
		JLabel height_label = new JLabel("Height: " + height_slider.getValue());
		height_slider.setMinimum(10);
		height_slider.setMaximum(500);
		this.width_slider = new JSlider();
		JLabel width_label = new JLabel("Width: " + width_slider.getValue());
		width_slider.setMinimum(10);
		width_slider.setMaximum(500);
		this.low_survive_slider = new JSlider();
		JLabel low_survive_label = new JLabel("Low Survive Threshold: " + low_survive_slider.getValue());
		low_survive_slider.setMinimum(1);
		low_survive_slider.setMaximum(8);
		this.high_survive_slider = new JSlider();
		JLabel high_survive_label = new JLabel("High Survive Threshold: " + high_survive_slider.getValue());
		high_survive_slider.setMinimum(low_survive_slider.getValue());
		high_survive_slider.setMaximum(8);
		this.low_birth_slider = new JSlider();
		JLabel low_birth_label = new JLabel("Low Birth Threshold: " + low_birth_slider.getValue());
		low_birth_slider.setMinimum(1);
		low_birth_slider.setMaximum(8);
		this.high_birth_slider = new JSlider();
		JLabel high_birth_label = new JLabel("High Birth Threshold: " + high_birth_slider.getValue());
		high_birth_slider.setMinimum(low_birth_slider.getValue());
		high_birth_slider.setMaximum(8);
		
		height_slider.addChangeListener(this);
		width_slider.addChangeListener(this);
		low_survive_slider.addChangeListener(this);
		high_survive_slider.addChangeListener(this);
		low_birth_slider.addChangeListener(this);
		high_birth_slider.addChangeListener(this);
		
		JPanel info_panel_one = new JPanel();
		info_panel_one.setLayout(new BorderLayout());
		info_panel_one.add(height_label, BorderLayout.WEST);
		info_panel_one.add(width_label, BorderLayout.EAST);
		add(info_panel_one, BorderLayout.NORTH);
		
		JPanel info_panel_two = new JPanel();
		info_panel_two.setLayout(new BorderLayout());
		info_panel_two.add(height_slider, BorderLayout.WEST);
		info_panel_two.add(width_slider, BorderLayout.EAST);
		info_panel_one.add(info_panel_two, BorderLayout.SOUTH);
		
		JPanel info_panel_three = new JPanel();
		info_panel_three.setLayout(new BorderLayout());
		info_panel_three.add(low_survive_label, BorderLayout.WEST);
		info_panel_three.add(high_survive_label, BorderLayout.EAST);
		info_panel_two.add(info_panel_three, BorderLayout.SOUTH);
		
		JPanel info_panel_four = new JPanel();
		info_panel_four.setLayout(new BorderLayout());
		info_panel_four.add(low_survive_slider, BorderLayout.WEST);
		info_panel_four.add(high_survive_slider, BorderLayout.EAST);
		info_panel_three.add(info_panel_four, BorderLayout.SOUTH);
		
		JPanel info_panel_five = new JPanel();
		info_panel_five.setLayout(new BorderLayout());
		info_panel_five.add(low_birth_label, BorderLayout.WEST);
		info_panel_five.add(high_birth_label, BorderLayout.EAST);
		info_panel_four.add(info_panel_five, BorderLayout.SOUTH);
		
		JPanel info_panel_six = new JPanel();
		info_panel_six.setLayout(new BorderLayout());
		info_panel_six.add(low_birth_slider, BorderLayout.WEST);
		info_panel_six.add(high_birth_slider, BorderLayout.EAST);
		info_panel_five.add(info_panel_six, BorderLayout.SOUTH);
		
		reset_message_panel.add(run_button, BorderLayout.CENTER);
		reset_message_panel.add(clear_button, BorderLayout.WEST);
		reset_message_panel.add(random_button, BorderLayout.EAST);
		add(reset_message_panel, BorderLayout.SOUTH);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				board.getSpotAt(i, j).setBackground(Color.WHITE);
			}
		}
	}
	
	public void show(int[][] board_array) {
		for (int i = 0; i < board_array.length; i++) {
			for (int j = 0; j < board_array[0].length; j++) {
				if (board_array[i][j] == 0) {
					board.getSpotAt(i, j).setBackground(Color.WHITE);
				} else {
					board.getSpotAt(i, j).setBackground(Color.BLACK);
				}
			}
		}
	}
	
	public void addController(LifeController controller) {
		this.controller = controller;
	}

	@Override
	public void spotClicked(Spot spot) {
		if (spot == null) {
			return;
		}
		int x = spot.getSpotX();
		int y = spot.getSpotY();
		if (spot.getBackground() == Color.WHITE) {
			spot.setBackground(Color.BLACK);
			controller.spotClicked(x, y, 1);
		} else {
			spot.setBackground(Color.WHITE);
			controller.spotClicked(x, y, 0);
		}
	}

	@Override
	public void spotEntered(Spot spot) {
	}

	@Override
	public void spotExited(Spot spot) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		LifeViewEvent x = null;
		if (button.equals(random_button)) {
			x = new RandomEvent("Randomize");
		} else if (button.equals(run_button)) {
			x = new RunEvent("Run");
		} else if (button.equals(clear_button)) {
			x = new ClearEvent("Clear");
		} else if (button.getText().equals("Toggle Torus")) {
			x = new TorusEvent("Torus");
		}
		controller.action(x);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider) e.getSource();
		LifeViewEvent x = null;
		if (slider.equals(height_slider)) {
			x = new HeightSlideEvent();
		} else if (slider.equals(width_slider)) {
			x = new WidthSlideEvent();
		} else if (slider.equals(low_survive_slider)) {
			x = new LowSurviveSlideEvent();
		} else if (slider.equals(high_survive_slider)) {
			x = new HighSurviveSlideEvent();
		} else if (slider.equals(low_birth_slider)) {
			x = new LowBirthSlideEvent();
		} else if (slider.equals(high_birth_slider)) {
			x = new HighBirthSlideEvent();
		} else 
		controller.action(x);
	}
	
	public JSlider getHeightSlide() {
		return this.height_slider;
	}
	
	public JSlider getWidthSlide() {
		return this.width_slider;
	}
	
	public JSlider getLowSurviveSlide() {
		return this.low_survive_slider;
	}
	
	public JSlider getHighSurviveSlide() {
		return this.high_survive_slider;
	}
	
	public JSlider getLowBirthSlide() {
		return this.low_birth_slider;
	}
	
	public JSlider getHighBirthSlide() {
		return this.high_birth_slider;
	}
}


package a8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class LifeModel {

	private int [][] board;
	private int counter;
	private int height;
	private int width;
	private int upper_birth_thresh;
	private int lower_birth_thresh;
	private int upper_survive_thresh;
	private int lower_survive_thresh;

	public LifeModel() {

		this.width = 20;
		this.height = 20;
		board = new int[width][height];
		counter = 0;
		this.upper_birth_thresh = 3;
		this.lower_birth_thresh = 3;
		this.upper_survive_thresh = 3;
		this.lower_survive_thresh = 2;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public LifeModel(int width, int height) {

		this.width = width;
		this.height = height;
		board = new int[width][height];
		counter = 0;
		this.upper_birth_thresh = 3;
		this.lower_birth_thresh = 3;
		this.upper_survive_thresh = 3;
		this.lower_survive_thresh = 2;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public LifeModel(int upper_birth_thresh, int lower_birth_thresh, 
			int upper_survive_thresh, int lower_death_thresh) {

		this.width = 20;
		this.height = 20;
		board = new int[width][height];
		counter = 0;
		this.upper_birth_thresh = upper_birth_thresh;
		this.lower_birth_thresh = lower_birth_thresh;
		this.upper_survive_thresh = upper_survive_thresh;
		this.lower_survive_thresh = lower_survive_thresh;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public LifeModel(int width, int height, int upper_birth_thresh, int lower_birth_thresh, 
			int upper_survive_thresh, int lower_survive_thresh) {

		this.width = width;
		this.height = height;
		board = new int[width][height];
		counter = 0;
		this.upper_birth_thresh = upper_birth_thresh;
		this.lower_birth_thresh = lower_birth_thresh;
		this.upper_survive_thresh = upper_survive_thresh;
		this.lower_survive_thresh = lower_survive_thresh;
		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}

	public int[][] getBoard(){
		return this.board;
	}
	
	public void setBoard(int[][] board){
		this.board = board;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int x) {
		this.width = x;
		this.board = new int [width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int x) {
		this.height = x;
		this.board = new int [width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				board[i][j] = 0;
			}
		}
	}
	
	public void setSpot(int x, int y, int z) {
		board[x][y] = z;
	}
	
	public int getUpperBirthThresh() {
		return upper_birth_thresh;
	}
	
	public void setUpperBirthThresh(int x) {
		upper_birth_thresh = x;
	}
	
	public int getLowerBirthThresh() {
		return lower_birth_thresh;
	}
	
	public void setLowerBirthThresh(int x) {
		lower_birth_thresh = x;
	}
	
	public int getUpperSurviveThresh() {
		return upper_survive_thresh;
	}
	
	public void setUpperSurviveThresh(int x) {
		upper_survive_thresh = x;
	}
	
	public int getLowerSurviveThresh() {
		return lower_survive_thresh;
	}
	
	public void setLowerSurviveThresh(int x) {
		lower_survive_thresh = x;
	}
	
	
}

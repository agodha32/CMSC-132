package model;

/**
 * This class represents the logic of a game where a board is updated on each
 * step of the game animation. The board can also be updated by selecting a
 * board cell.
 * 
 * @author Department of Computer Science, UMCP
 */

public abstract class Game {
	
	
	protected BoardCell[][] board;

	/**
	 * Defines a board with BoardCell.EMPTY cells.
	 * 
	 * @param maxRows
	 * @param maxCols
	 */
	public Game(int maxRows, int maxCols) {

		this.board = new BoardCell[maxRows][maxCols];
		
		for(int rowInitialize = 0; board.length > rowInitialize; rowInitialize++) {
			
			for(int colInitialize = 0; board[0].length > colInitialize; colInitialize++) {
				
				board[rowInitialize][colInitialize] = BoardCell.EMPTY;
				
			}
			
		}
	
	}

	public int getMaxRows() {

		return this.board.length;
	
	}

	public int getMaxCols() {

		return this.board[0].length;
	
	}

	public void setBoardCell(int rowIndex, int colIndex, BoardCell boardCell) {

		this.board[rowIndex][colIndex] = boardCell;
	
	}

	public BoardCell getBoardCell(int rowIndex, int colIndex) {

		return this.board[rowIndex][colIndex];
	
	}

	/**
	 * Initializes row with the specified color.
	 * 
	 * @param rowIndex
	 * @param cell
	 */
	public void setRowWithColor(int rowIndex, BoardCell cell) {

		for(int colorSet = 0; this.board[rowIndex].length > colorSet; colorSet++) {
			
			this.board[rowIndex][colorSet] = cell;
			
		}
	
	}

	/**
	 * Initializes column with the specified color.
	 * 
	 * @param colIndex
	 * @param cell
	 */
	public void setColWithColor(int colIndex, BoardCell cell) {

		for(int rowIndex = 0; this.board.length > rowIndex; rowIndex++) {
			
			this.board[rowIndex][colIndex] = cell;
			
		}
		
	}

	/**
	 * Initializes the board with the specified color.
	 * 
	 * @param cell
	 */
	public void setBoardWithColor(BoardCell cell) {

		for(int row = 0; this.board.length > row; row++) {
			
			for(int col = 0; this.board[row].length > col; col++) {
				
				this.board[row][col] = cell;
				
			}
			
		}
	
	}

	public abstract boolean isGameOver();

	public abstract int getScore();

	/**
	 * Advances the animation one step.
	 */
	public abstract void nextAnimationStep();

	/**
	 * Adjust the board state according to the current board state and the selected
	 * cell.
	 * 
	 * @param rowIndex
	 * @param colIndex
	 */
	public abstract void processCell(int rowIndex, int colIndex);
}
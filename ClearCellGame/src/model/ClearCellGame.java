package model;

import java.util.Random;

/**
 * This class extends GameModel and implements the logic of the clear cell game.
 * We define an empty cell as BoardCell.EMPTY. An empty row is defined as one
 * where every cell corresponds to BoardCell.EMPTY.
 * 
 * @author Department of Computer Science, UMCP
 */

public class ClearCellGame extends Game {

	private Random random;
	private int strategy;
	private int score;

	/**
	 * Defines a board with empty cells. It relies on the super class constructor to
	 * define the board. The random parameter is used for the generation of random
	 * cells. The strategy parameter defines which clearing cell strategy to use
	 * (for this project it will be 1). For fun, you can add your own strategy by
	 * using a value different that one.
	 * 
	 * @param maxRows
	 * @param maxCols
	 * @param random
	 * @param strategy
	 */
	public ClearCellGame(int maxRows, int maxCols, Random random, int strategy) {

		super(maxRows, maxCols);
		this.strategy = strategy;
		this.random = random;
		this.score = 0;

	}

	/**
	 * The game is over when the last board row (row with index board.length -1) is
	 * different from empty row.
	 */
	public boolean isGameOver() {
		
		int currentColEmptyCount = 0;

		for (int colIndex = 0; board[0].length > colIndex; colIndex++) {

			if (board[board.length - 1][colIndex] != BoardCell.EMPTY) {

				currentColEmptyCount++;  

			}

		}

		return currentColEmptyCount > 0;
	}

	public int getScore() {

		return this.score;

	}

	/**
	 * This method will attempt to insert a row of random BoardCell objects if the
	 * last board row (row with index board.length -1) corresponds to the empty row;
	 * otherwise no operation will take place.
	 */
	public void nextAnimationStep() {

		if (isGameOver() == false) {

			for(int rowIndex = board.length - 2; rowIndex >= 0; rowIndex--) {
				
				board[rowIndex+1] = board[rowIndex];
			
				
			}

			BoardCell [] x = new BoardCell [board[0].length]; 
			
			for(int colIndex = 0; this.board[0].length > colIndex; colIndex++) {					
					
				x[colIndex] = BoardCell.getNonEmptyRandomBoardCell(random);
				
			}
			
			board[0] = x;
				
		}
	

	}

	/**
	 * This method will turn to BoardCell.EMPTY the cell selected and any adjacent
	 * surrounding cells in the vertical, horizontal, and diagonal directions that
	 * have the same color. The clearing of adjacent cells will continue as long as
	 * cells have a color that corresponds to the selected cell. Notice that the
	 * clearing process does not clear every single cell that surrounds a cell
	 * selected (only those found in the vertical, horizontal or diagonal
	 * directions).
	 * 
	 * IMPORTANT: Clearing a cell adds one point to the game's score.<br />
	 * <br />
	 * 
	 * If after processing cells, any rows in the board are empty,those rows will
	 * collapse, moving non-empty rows upward. For example, if we have the following
	 * board (an * represents an empty cell):<br />
	 * <br />
	 * RRR<br />
	 * GGG<br />
	 * YYY<br />
	 * * * *<br/>
	 * <br />
	 * then processing each cell of the second row will generate the following
	 * board<br />
	 * <br />
	 * RRR<br />
	 * YYY<br />
	 * * * *<br/>
	 * * * *<br/>
	 * <br />
	 * IMPORTANT: If the game has ended no action will take place.
	 * 
	 * 
	 */
	public void processCell(int rowIndex, int colIndex) {

		BoardCell color = board[rowIndex][colIndex];
		boolean clearDirection = true;
		int rowChecker = rowIndex; 
		int colChecker = colIndex;

		if (!isGameOver()) {
			
			//add the row
			while(clearDirection == true) {
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker++;
					
				}
					
			}
			
			clearDirection = true;
			
			rowChecker = rowIndex - 1;
			colChecker = colIndex;
			
			while(clearDirection == true) {
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker--;
					
				}
					
			}
				
			clearDirection = true;
			
			rowChecker = rowIndex;
			colChecker = colIndex + 1;
			
			while(clearDirection == true) {
				
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					colChecker++;
					
				}
					
			}
			
			clearDirection = true;
			
			rowChecker = rowIndex;
			colChecker = colIndex - 1;
			
			while(clearDirection == true) {
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					colChecker--;
					
				}
					
			}

			clearDirection = true;
			
			rowChecker = rowIndex - 1;
			colChecker = colIndex + 1;
			
			while(clearDirection == true) {
				
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker--;
					colChecker++;
					
				}
					
			}
			
			clearDirection = true;
			
			rowChecker = rowIndex - 1;
			colChecker = colIndex - 1;
			
			while(clearDirection == true) {
				
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker--;
					colChecker--;
					
				}
					
			}
			
			clearDirection = true;
			
			rowChecker = rowIndex + 1;
			colChecker = colIndex - 1;
			
			while(clearDirection == true) {
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker++;
					colChecker--;
					
				}
					
			}
			
			clearDirection = true;
			
			rowChecker = rowIndex + 1;
			colChecker = colIndex + 1;
			
			while(clearDirection == true) {
				
				clearDirection = cellClearer(rowChecker, colChecker, color);
				
				if(clearDirection == true) {
					
					rowChecker++;
					colChecker++;
					
				}
					
			}

			int totalCol = board[0].length;
			
			for(int row = 0; board.length > row; row++) {
				
				int emptyCellCounter = 0;
				
				for(int col = 0; board[row].length > col; col++) {
					
					if(board[row][col] == BoardCell.EMPTY) {
						
						emptyCellCounter++;
						
					}
					
				}
				
				if(emptyCellCounter == totalCol) {
					
					for(int removeRow = row + 1; board.length > removeRow; removeRow++) {
						
						for(int col = 0; board[removeRow].length > col; col++) {
						
							board[removeRow - 1][col] = board[removeRow][col];
						
						}
					
					}
					
				}
				
			}
			
		}
		
	}
	
	private boolean cellClearer(int rowIndex, int colIndex, BoardCell cellToRemove) {
		
		if(rowIndex >= 0 && colIndex >=0 && rowIndex < board.length &&
				colIndex < board[0].length && board[rowIndex][colIndex] == cellToRemove) {
			
			board[rowIndex][colIndex] = BoardCell.EMPTY;
			this.score++;
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
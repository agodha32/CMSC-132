package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.BoardCell;
import model.ClearCellGame;
import model.Game;

/* The following directive executes tests in sorted order */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	
	@Test
	public void testBasicGameMethods() {

		Game testBoard = new ClearCellGame(4,10, new Random(1L), 1);
		
		getBoardStr(testBoard);
				
		assertTrue(testBoard.getMaxRows() == 4);
		assertTrue(testBoard.getMaxCols() == 10);
		
		assertTrue(testBoard.getBoardCell(0, 0) == BoardCell.EMPTY);
		assertTrue(testBoard.getBoardCell(3, 0) == BoardCell.EMPTY);
		assertTrue(testBoard.getBoardCell(3, 9) == BoardCell.EMPTY);
		assertTrue(testBoard.getBoardCell(0, 9) == BoardCell.EMPTY);
		assertTrue(testBoard.getBoardCell(2, 5) == BoardCell.EMPTY);
				
		testBoard.setBoardCell(0, 0, BoardCell.BLUE);
		testBoard.setBoardCell(3, 0, BoardCell.GREEN);
		testBoard.setBoardCell(3, 9, BoardCell.RED);
		testBoard.setBoardCell(0, 9, BoardCell.YELLOW);
		testBoard.setBoardCell(2, 5, BoardCell.getNonEmptyRandomBoardCell(new Random(4L)));
				
		assertTrue(testBoard.getBoardCell(0, 0) == BoardCell.BLUE);
		assertTrue(testBoard.getBoardCell(3, 0) == BoardCell.GREEN);
		assertTrue(testBoard.getBoardCell(3, 9) == BoardCell.RED);
		assertTrue(testBoard.getBoardCell(0, 9) == BoardCell.YELLOW);
		assertTrue(testBoard.getBoardCell(2, 5) != BoardCell.EMPTY);
		
		testBoard.setRowWithColor(1, BoardCell.GREEN);
			
		int counter = 0;
		
		for(int x = 0; testBoard.getMaxCols() > x; x++) {
			
			if(testBoard.getBoardCell(1, x) == BoardCell.GREEN ) {
				
				counter++;
				
			}
			
		}
		
		
		assertTrue(testBoard.getMaxCols() == counter);
	
		testBoard.setColWithColor(1, BoardCell.RED);
				
		counter = 0;
		
		for(int x = 0; testBoard.getMaxRows() > x; x++) {
			
			if(testBoard.getBoardCell(x, 1) == BoardCell.RED ) {
				
				counter++;
				
			}
			
		}	
		
		assertTrue(testBoard.getMaxRows() == counter);
		
	}
	
	@Test
	public void testIsGameOverAndScore() {

		Game testBoard = new ClearCellGame(5,5, new Random(1L), 1);
		
		assertFalse(testBoard.isGameOver() == true);
		
		testBoard.setRowWithColor(0, BoardCell.RED);
		testBoard.setRowWithColor(1, BoardCell.GREEN);
		testBoard.setRowWithColor(2, BoardCell.YELLOW);
		testBoard.setRowWithColor(3, BoardCell.BLUE);
		testBoard.setRowWithColor(4, BoardCell.BLUE);
				
		assertTrue(testBoard.getScore() == 0);
		assertTrue(testBoard.isGameOver() == true);
	
	}
	
	@Test
	public void testNnextAnimation() {
		
		Game testBoard = new ClearCellGame(4, 5, new Random(2L), 1);
		testBoard.nextAnimationStep();
		testBoard.nextAnimationStep();
		
		int counter = 0;
		
		for(int x = 0; testBoard.getMaxCols() > x; x++) {
			
			if(testBoard.getBoardCell(0, x) != BoardCell.EMPTY) {
				
				counter++;
				
			}
			
		}	
		
		assertTrue(testBoard.getMaxCols() == counter);
		
		counter = 0;

		for(int x = 0; testBoard.getMaxCols() > x; x++) {
			
			if(testBoard.getBoardCell(3, x) == BoardCell.EMPTY) {
				
				counter++;
				
			}
			
		}	
				
		assertTrue(testBoard.getMaxCols() == counter);

	}

	@Test
	public void testProcessCell() {
				
		Game testBoard = new ClearCellGame(4, 5, new Random(1L), 1);

		testBoard.setBoardWithColor(BoardCell.BLUE);
		testBoard.setRowWithColor(1, BoardCell.YELLOW);
		testBoard.setRowWithColor(2, BoardCell.RED);
		
	}
	
	private static String getBoardStr(Game game) {
		
		int maxRows = game.getMaxRows(), maxCols = game.getMaxCols();

		String answer = "Board(Rows: " + maxRows + ", Columns: " + maxCols + ")\n"
				;
		for (int row = 0; row < maxRows; row++) {
			
			for (int col = 0; col < maxCols; col++) {
				
				answer += game.getBoardCell(row, col).getName();
				
			}
			
			answer += "\n";
		
		}

		return answer;
	
	}
	
}

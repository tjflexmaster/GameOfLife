package tj.GameOfLife;

import java.util.HashMap;

import tj.GameOfLife.Cell.CellState;

public class GameOfLife {
	
	public static void main(String[] args) {
		
		System.out.println("Running the Game of Life");
		
		GameEngine engine = new GameEngine();
		
//		StandardGameBoard board = new StandardGameBoard(4,4);
//		board.setCell(new Cell(new Location(1,1), CellState.Live));
//		board.setCell(new Cell(new Location(1,2), CellState.Live));
//		board.setCell(new Cell(new Location(2,1), CellState.Live));
//		board.setCell(new Cell(new Location(2,2), CellState.Live));
		
		StandardGameBoard board = new StandardGameBoard(5,5);
		board.setCell(new Cell(new Location(2,1), CellState.Live));
		board.setCell(new Cell(new Location(2,2), CellState.Live));
		board.setCell(new Cell(new Location(2,3), CellState.Live));
		
		for(int i=0; i < 5; i++)
		{
			board.applyGameEngine(engine);
			
			HashMap<Location, Cell> liveCells = board.getLiveCells();
			for(HashMap.Entry<Location,Cell> entry : liveCells.entrySet())
			{
				Cell cell = entry.getValue();
				System.out.println(cell.toString());
			}
		}
		
		System.out.println("Using Wrap Around Game Board");

		WrapAroundGameBoard board2 = new WrapAroundGameBoard(5,5);
		board2.setCell(new Cell(new Location(2,1), CellState.Live));
		board2.setCell(new Cell(new Location(2,2), CellState.Live));
		board2.setCell(new Cell(new Location(2,3), CellState.Live));
		
		for(int i=0; i < 5; i++)
		{
			board2.applyGameEngine(engine);
			
			HashMap<Location, Cell> liveCells = board2.getLiveCells();
			for(HashMap.Entry<Location,Cell> entry : liveCells.entrySet())
			{
				Cell cell = entry.getValue();
				System.out.println(cell.toString());
			}
		}
	}

}

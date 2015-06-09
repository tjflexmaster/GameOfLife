package tj.GameOfLife;

import java.util.HashMap;
import java.util.Map;

import tj.GameOfLife.GridCell.CellState;

public class GameOfLife {
	
	public static void main(String[] args) {
		
		final int defaultRowCount = 5;
		final int defaultColumnCount = 5;
		
		final int defaultGameEngineStepCount = 5;
		
		GridCell[] lineSeed = {
			new GridCell(2, 1, CellState.Live),
			new GridCell(2, 2, CellState.Live),
			new GridCell(2, 3, CellState.Live)
		};
		
		SingleStepGameEngine singleStepEngine = new SingleStepGameEngine();
		MultiStepGameEngine multiStepEngine = new MultiStepGameEngine(defaultGameEngineStepCount);
		HashMap<GridLocation, GridCell> liveCells = new HashMap<GridLocation, GridCell>();
		
		System.out.println("Using Standard Game Board");
		
		StandardGameBoard standardBoard = new StandardGameBoard(defaultRowCount, defaultColumnCount);
		standardBoard.setCells(lineSeed);
		standardBoard.getLiveCells(liveCells);
		printLiveCells(liveCells);
		
		liveCells.clear();
		standardBoard.applyVisitor(singleStepEngine);
		standardBoard.getLiveCells(liveCells);
		printLiveCells(liveCells);
		
		liveCells.clear();
		standardBoard.applyVisitor(singleStepEngine);
		standardBoard.getLiveCells(liveCells);
		printLiveCells(liveCells);
		
		
//		System.out.println("Using Wrap Around Game Board");
//		liveCells.clear();
//
//		WrapAroundGameBoard wrapAroundBoard = new WrapAroundGameBoard(defaultRowCount, defaultColumnCount);
//		wrapAroundBoard.setCells(lineSeed);
//		wrapAroundBoard.applyVisitor(multiStepEngine);
//		standardBoard.getLiveCells(liveCells);
//		
//		printLiveCells(liveCells);
	}

	private static void printLiveCells(Map<GridLocation, GridCell> liveCells)
	{
		for(Map.Entry<GridLocation,GridCell> entry : liveCells.entrySet())
		{
			System.out.println(entry.getValue().toString());
		}
	}
}

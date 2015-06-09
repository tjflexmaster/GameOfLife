package tj.GameOfLife;

import java.util.HashSet;
import java.util.HashMap;

import tj.GameOfLife.GridCell.CellState;

class MutableInt {
	
	public MutableInt() {}
	
	public MutableInt(int value)
	{
		m_value = value;
	}
	
	public void increment() 
	{ 
		++m_value;      
	}
	
	public int get()
	{ 
		return m_value; 
	}
	
	int m_value = 0; 
}


public class SingleStepGameEngine implements IGameBoardVisitor 
{
	/** Stores a histogram of the number of neighbors 
	 * 	for each cell that is a neighbor of a live cell.
	 */
	private HashMap<GridLocation, MutableInt> liveNeighborHistogram = 
			new HashMap<GridLocation, MutableInt>();
	
	@Override
	public void visit(IGameBoard board) 
	{
		liveNeighborHistogram.clear();
		
		HashMap<GridLocation, GridCell> liveCells = 
				new HashMap<GridLocation, GridCell>();
		board.getLiveCells(liveCells);
		
		buildLiveNeighborHistogram(board, liveCells);
		
		board.clearCells();
		
		updateGameBoard(board, liveCells);
		
	}
	
	private void buildLiveNeighborHistogram(IGameBoard board, HashMap<GridLocation, GridCell> liveCells)
	{
		for(HashMap.Entry<GridLocation,GridCell> entry : liveCells.entrySet())
		{
			GridCell cell = entry.getValue();
			try
			{
				HashSet<GridLocation> neighborLocations = new HashSet<GridLocation>();
				board.getCellNeighborLocations(cell, neighborLocations);
				
				for(GridLocation location : neighborLocations)
				{
					MutableInt count = liveNeighborHistogram.get(location);
					if(count == null)
					{
						liveNeighborHistogram.put(location, new MutableInt(1));
//								System.out.println("Added " + location.toString());
					}
					else
					{
						count.increment();
//								System.out.println("Incremented " + location.toString() + " Count=" + Integer.toString(count.get()));
					}
				}
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(new StringBuilder().append(e.getMessage()).
						append(" at ").
						append(cell.toString()).
						toString());
			}
		}
	}
	
	private void updateGameBoard(IGameBoard board, HashMap<GridLocation, GridCell> liveCells)
	{
		// Check if the cell is now live, if so then update the game board
		for (HashMap.Entry<GridLocation, MutableInt> entry : liveNeighborHistogram.entrySet()) 
		{
			GridCell cell = liveCells.get(entry.getKey());
			int liveNeighborCount = entry.getValue().get();
			if(cell != null)
			{
				if( keepCellAlive(liveNeighborCount) )
					board.setCell(cell);
			}
			else
			{
				if( regenerateCell(liveNeighborCount) )
					board.setCell(new GridCell(entry.getKey(), CellState.Live));
			}
		}
	}
	
	private boolean keepCellAlive(int liveNeighbors)
	{
		if(liveNeighbors == 2 || liveNeighbors == 3)
		{
			System.out.println("Stayed alive.");
			return true;
		}
			
		return false;
	}
	
	private boolean regenerateCell(int liveNeighbors)
	{
		if(liveNeighbors == 3)
		{
			System.out.println("Spontaneous regeneration.");
			return true;
		}
		
		return false;
	}
}

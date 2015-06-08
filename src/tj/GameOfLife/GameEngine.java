package tj.GameOfLife;

import java.util.HashSet;
import java.util.HashMap;

import tj.GameOfLife.Cell.CellState;

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


public class GameEngine implements IGameEngine {
	
	@Override
	public void run(IGameBoard board) 
	{	
		// Reset any stored values
		reset();
		
		// Get the Live Cells
		HashMap<Location, Cell> liveCells = board.getLiveCells();
		
		// Count how many times each cell is touched by a live neighbor
		getNeighborCount(board, liveCells);
		
		// Clear the GameBoard
		board.clearCells();
		
		// Set the cleared board to show live cells
		updateGameBoard(board, liveCells);
	}
	
	private void getNeighborCount(IGameBoard board, HashMap<Location, Cell> liveCells)
	{
		// Count up the live neighbors for each cell touching a live cell
		for(HashMap.Entry<Location,Cell> entry : liveCells.entrySet())
		{
			Cell cell = entry.getValue();
			try
			{
				HashSet<Location> neighborLocations = board.getCellNeighborLocations(cell);
				for(Location location : neighborLocations)
				{
					MutableInt count = m_neighborCounts.get(location);
					if(count == null)
					{
						m_neighborCounts.put(location, new MutableInt(1));
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
				System.out.println(e.getMessage());
				System.out.println("Cell: " + cell.getLocation().toString());
			}
		}
	}
	
	private void updateGameBoard(IGameBoard board, HashMap<Location, Cell> liveCells)
	{
		// Check if the cell is now live, if so then update the game board
		for (HashMap.Entry<Location, MutableInt> entry : m_neighborCounts.entrySet()) 
		{
			Cell cell = liveCells.get(entry.getKey());
			int liveNeighborCount = entry.getValue().get();
			if(cell != null)
			{
				if(doesLiveCellLive(liveNeighborCount))
					board.setCell(cell);
			}
			else
			{
				if( doesDeadCellLive(liveNeighborCount) )
					board.setCell(new Cell(entry.getKey(), CellState.Live));
			}
		}
	}
	
	private boolean doesLiveCellLive(int liveNeighbors)
	{
		if(liveNeighbors == 2 || liveNeighbors == 3)
		{
			System.out.println("Stayed alive.");
			return true;
		}
			
		return false;
	}
	
	private boolean doesDeadCellLive(int liveNeighbors)
	{
		if(liveNeighbors == 3)
		{
			System.out.println("Spontaneous regeneration.");
			return true;
		}
		
		return false;
	}
	
	private void reset()
	{
		m_neighborCounts.clear();
	}


	/** Stores a map of that counts the number of live cells touching cells
	 * 	that border live cells.
	 */
	private HashMap<Location, MutableInt> m_neighborCounts = new HashMap<Location, MutableInt>();
}

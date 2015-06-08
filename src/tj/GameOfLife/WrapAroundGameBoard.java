package tj.GameOfLife;

import java.util.HashSet;

public class WrapAroundGameBoard extends GameBoard 
{

	public WrapAroundGameBoard(int width, int height) throws IllegalArgumentException
	{
		super(width, height);
	}
	
	@Override
	public HashSet<Location> getCellNeighborLocations(Cell cell) throws IllegalArgumentException 
	{
		if( !validCell(cell) )
			throw new IllegalArgumentException("Invalid cell location.  Cell must be found on the game board.");
		
		int x = cell.getLocation().getX();
		int y = cell.getLocation().getY();
		int xLess = (x == 0) ? m_maxX : x-1;
		int xMore = (x == m_maxX) ? 0 : x+1;
		int yLess = (y == 0) ? m_maxY : y-1;
		int yMore = (y == m_maxY) ? 0 : y+1; 
		
		HashSet<Location> result = new HashSet<Location>();
		
		result.add(new Location(xLess, yLess));
		result.add(new Location(xLess, y));
		result.add(new Location(xLess, yMore));
		result.add(new Location(x, yLess));
		result.add(new Location(x, yMore));
		result.add(new Location(xMore, yLess));
		result.add(new Location(xMore, y));
		result.add(new Location(xMore, yMore));
		
		return result;
	}
	
	@Override
	public void applyGameEngine(IGameEngine engine) 
	{
		engine.run(this);
	}

}

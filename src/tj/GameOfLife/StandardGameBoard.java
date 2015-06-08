package tj.GameOfLife;

import java.util.HashSet;

public class StandardGameBoard extends GameBoard
{
	
	public StandardGameBoard(int width, int height) throws IllegalArgumentException
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
		
		if( y == 0) // top row
			return topRowNeighbors(x);
		else if( y == m_maxY) // bottom row
			return bottomRowNeighbors(x);
		else // middle rows
			return middleRowNeighbors(x,y);
	}
	
	@Override
	public void applyGameEngine(IGameEngine engine) {
		engine.run(this);
	}
	
	//########### PRIVATE METHODS ###############
	
	private HashSet<Location> topRowNeighbors(int x)
	{
		HashSet<Location> result = new HashSet<Location>();
		if(x == 0)
		{ // left col
			result.add(new Location(0,1));
			result.add(new Location(1,1));
			result.add(new Location(1,0));
		}
		else if(x == m_maxX)
		{ // right col
			result.add(new Location(m_maxX--, 0));
			result.add(new Location(m_maxX--, 1));
			result.add(new Location(m_maxX, 1));
		}
		else
		{ // middle cols
			result.add(new Location(x-1, 0));
			result.add(new Location(x+1, 0));
			result.add(new Location(x-1, 1));
			result.add(new Location(x, 1));
			result.add(new Location(x+1, 1));
		}
		return result;
	}
	
	private HashSet<Location> bottomRowNeighbors(int x)
	{
		HashSet<Location> result = new HashSet<Location>();
		if(x == 0)
		{ // left col
			result.add(new Location(0,m_maxY--));
			result.add(new Location(1,m_maxY--));
			result.add(new Location(1,m_maxY));
		}
		else if(x == m_maxX)
		{ // right col
			result.add(new Location(m_maxX--, m_maxY));
			result.add(new Location(m_maxX--, m_maxY--));
			result.add(new Location(m_maxX, m_maxY--));
		}
		else
		{ // middle cols
			result.add(new Location(x-1, m_maxY));
			result.add(new Location(x+1, m_maxY));
			result.add(new Location(x-1, m_maxY--));
			result.add(new Location(x, m_maxY--));
			result.add(new Location(x+1, m_maxY--));
		}
		return result;
	}
	
	private HashSet<Location> middleRowNeighbors(int x, int y)
	{
		HashSet<Location> result = new HashSet<Location>();
		if(x == 0)
		{ // left col
			result.add(new Location(0, y-1));
			result.add(new Location(0, y+1));
			result.add(new Location(1, y-1));
			result.add(new Location(1, y));
			result.add(new Location(1, y+1));
		}
		else if(x == m_maxX)
		{ // right col
			result.add(new Location(m_maxX, y-1));
			result.add(new Location(m_maxX, y+1));
			result.add(new Location(m_maxX--, y-1));
			result.add(new Location(m_maxX--, y));
			result.add(new Location(m_maxX--, y+1));
		}
		else
		{ // middle cols
			result.add(new Location(x-1, y-1));
			result.add(new Location(x-1, y));
			result.add(new Location(x-1, y+1));
			result.add(new Location(x, y-1));
			result.add(new Location(x, y+1));
			result.add(new Location(x+1, y-1));
			result.add(new Location(x+1, y));
			result.add(new Location(x+1, y+1));
		}
		return result;
	}

}

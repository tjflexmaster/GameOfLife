package tj.GameOfLife;

import java.util.HashMap;
import java.util.HashSet;

public class StandardGameBoard implements IGameBoard
{
	
	public StandardGameBoard(int width, int height) throws IllegalArgumentException
	{
		if( width < 1 || height  < 1)
			throw new IllegalArgumentException("Invalid board size. Both the width and the height must be greater than 1.");
		
		m_width = width;
		m_height = height;
		m_maxX = m_width - 1;
		m_maxY = m_height - 1;
		m_liveCells = new HashMap<Location, Cell>();
	}
	
	//########### INTERFACE METHODS ###############
	@Override
	public int getWidth()
	{
		return new Integer(m_width);
	}
	
	@Override
	public int getHeight()
	{
		return new Integer(m_height);
	}
	
	@Override
	public HashMap<Location, Cell> getLiveCells() 
	{
		return new HashMap<Location, Cell>(m_liveCells);
	}
	
	@Override
	public void setCells(HashSet<Cell> cells) 
	{
		for(Cell cell : cells)
		{
			setCell(cell);
		}
	}
	
	@Override
	public void setCell(Cell cell)
	{
		if(cell.isAlive())
			m_liveCells.put(cell.getLocation(), cell);
	}
	
	@Override
	public void clearCells()
	{
		m_liveCells.clear();
	}

	@Override
	public void applyGameEngine(IGameEngine engine) {
		engine.run(this);
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
	
	private boolean validCell(Cell cell)
	{
		if( cell.getLocation().getX() < 0 || 
			cell.getLocation().getX() >= m_width )
			return false;
		
		if( cell.getLocation().getY() < 0 ||
			cell.getLocation().getY() >= m_height )
			return false;
		
		return true;
	}
	
	private int m_width;
	private int m_height;
	private int m_maxX;
	private int m_maxY;
	private HashMap<Location, Cell> m_liveCells;
}

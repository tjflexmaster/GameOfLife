package tj.GameOfLife;

import java.util.HashMap;
import java.util.HashSet;

public abstract class GameBoard implements IGameBoard {

	public GameBoard(int width, int height) throws IllegalArgumentException
	{
		if( width < 1 || height  < 1)
			throw new IllegalArgumentException("Invalid board size. Both the width and the height must be greater than 1.");
		
		m_maxX = width - 1;
		m_maxY = height - 1;
		m_liveCells = new HashMap<Location, Cell>();
	}
	
	//########### INTERFACE METHODS ###############
	@Override
	public int getWidth()
	{
		return m_maxX + 1;
	}
	
	@Override
	public int getHeight()
	{
		return m_maxY + 1;
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
		if(cell.isAlive() && validCell(cell))
			m_liveCells.put(cell.getLocation(), cell);
	}
	
	@Override
	public void clearCells()
	{
		m_liveCells.clear();
	}
	
	protected boolean validCell(Cell cell)
	{
		if( cell.getLocation().getX() < 0 || 
			cell.getLocation().getX() > m_maxX )
			return false;
		
		if( cell.getLocation().getY() < 0 ||
			cell.getLocation().getY() > m_maxY )
			return false;
		
		return true;
	}

	protected int m_maxX;
	protected int m_maxY;
	protected HashMap<Location, Cell> m_liveCells;
}

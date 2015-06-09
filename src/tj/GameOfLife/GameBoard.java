package tj.GameOfLife;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** GameBoard is an abstract class that represents a grid.
 * 	The top left corner being at (0,0) and the bottom right
 * 	corner being at (height-1, width-1).
 * 
 * @author TJ
 *
 */
public abstract class GameBoard implements IGameBoard 
{
	final protected Integer topRow = 0;
	final protected Integer leftColumn = 0;
	final protected Integer bottomRow;
	final protected Integer rightColumn;
	final protected Integer width;
	final protected Integer height;
	protected HashMap<GridLocation, GridCell> liveCells = new HashMap<GridLocation, GridCell>();
	
	public GameBoard(int width, int height) throws IllegalArgumentException
	{
		if( width < 1 || height  < 1)
			throw new IllegalArgumentException("Invalid board size. Both the width and the height must be greater than 1.");
		
		this.width = width;
		this.height = height;
		this.rightColumn = width - 1;
		this.bottomRow = height - 1;
	}
	
	@Override
	public Integer getWidth()
	{
		return this.width;
	}
	
	@Override
	public Integer getHeight()
	{
		return height;
	}
	
	@Override
	public void getLiveCells(Map<GridLocation, GridCell> outputMap) 
	{
		outputMap.putAll(liveCells);
	}
	
	@Override
	public void setCells(Set<GridCell> cells) 
	{
		for(GridCell cell : cells)
		{
			setCell(cell);
		}
	}
	
	@Override
	public void setCells(GridCell[] cells) 
	{
		for(GridCell cell : cells)
		{
			setCell(cell);
		}
	}
	
	@Override
	public void setCell(GridCell cell)
	{
		if(cell.isAlive() && validCell(cell))
			liveCells.put(cell.getLocation(), cell);
	}
	
	@Override
	public void clearCells()
	{
		liveCells.clear();
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result
				+ ((liveCells == null) ? 0 : liveCells.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof GameBoard))
		{
			return false;
		}
		
		GameBoard other = (GameBoard) obj;
		if (height == null) 
		{
			if (other.height != null)
				return false;
		} 
		else if (!height.equals(other.height))
		{
			return false;
		}
		
		if (liveCells == null) 
		{
			if (other.liveCells != null)
			{
				return false;
			}
		} 
		else if (!liveCells.equals(other.liveCells))
		{
			return false;
		}
		
		if (width == null) 
		{
			if (other.width != null)
			{
				return false;
			}
		} 
		else if (!width.equals(other.width))
		{
			return false;
		}
		
		return true;
	}
	
	protected boolean validCell(GridCell cell)
	{
		if( cell.getLocation().getRow() < topRow || 
			cell.getLocation().getRow() > bottomRow ||
			cell.getLocation().getColumn() < leftColumn ||
			cell.getLocation().getColumn() > rightColumn )
		{
			return false;
		}
		
		return true;
	}

	
}

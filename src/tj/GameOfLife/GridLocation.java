package tj.GameOfLife;

/** GridLocation defines the row and column of
 * 	a physical location on a Game of Life GameBoard.
 * 	
 * @author TJ
 *
 */
public class GridLocation {

	final private Integer row;
	final private Integer column;
	
	public GridLocation(int row, int column)
	{
		this.row = row;
		this.column = column;
	}
	
	public Integer getRow() 
	{ 
		return this.row; 
	}
	
	public Integer getColumn() 
	{ 
		return this.column; 
	}
	
	@Override 
	public String toString() 
	{
		return new StringBuffer().append("(").
				append(this.column).
				append(",").
				append(this.row).
				append(")").toString();
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
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
		
		if (!(obj instanceof GridLocation))
		{
			return false;
		}
		
		GridLocation other = (GridLocation) obj;
		if (column == null) 
		{
			if (other.column != null)
			{
				return false;
			}
		} 
		else if (!column.equals(other.column))
		{
			return false;
		}
		
		if (row == null) 
		{
			if (other.row != null)
			{
				return false;
			}
		} 
		else if (!row.equals(other.row))
		{
			return false;
		}
		
		return true;
	}
	
}

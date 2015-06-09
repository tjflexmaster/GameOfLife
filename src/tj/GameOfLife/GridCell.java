package tj.GameOfLife;

/** GridCell represents the state associated with
 * 	a GridLocation on a Game of Life GameBoard.
 * 	
 * @author TJ
 *
 */
public class GridCell {

	final private GridLocation location;
	private CellState state;
	
	public enum CellState
	{
		Live,
		Dead
	}
	
	public GridCell(int row, int column)
	{
		this(row, column, CellState.Dead);
	}
	
	public GridCell(int row, int column, CellState state)
	{
		this(new GridLocation(row, column),state);
	}
	
	public GridCell(GridLocation location)
	{
		this(location, CellState.Dead);
	}
	
	public GridCell(GridLocation location, CellState state)
	{
		this.location = location;
		this.state = state;
	}
	
	public GridLocation getLocation() 
	{
		return location;
	}
	
	public CellState getState() 
	{
		return state;
	}
	
	public boolean isAlive()
	{
		return state == CellState.Live;
	}

	public void setState(CellState m_state) {
		this.state = m_state;
	}
	
	@Override 
	public String toString() 
	{
		return new StringBuilder().append("GridCell(").
				append(getLocation().toString()).
				append(", ").
				append(isAlive() ? "Live":"Dead").
				append(")").toString();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		
		if (!(obj instanceof GridCell))
		{
			return false;
		}
		
		GridCell other = (GridCell) obj;
		if (location == null) 
		{
			if (other.location != null)
			{
				return false;
			}
		} 
		else if (!location.equals(other.location))
		{
			return false;
		}
		
		if (state != other.state)
		{
			return false;
		}
		return true;
	}
	

}

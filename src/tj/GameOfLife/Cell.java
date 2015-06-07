package tj.GameOfLife;

/** Cell represents the state of a physical location on a Game of Life GameBoard.
 * 	
 * @author TJ
 *
 */
public class Cell {

	public enum CellState
	{
		Live,
		Dead
	}
	
	public Cell(int x, int y)
	{
		init(new Location(x, y), CellState.Dead);
	}
	
	public Cell(int x, int y, CellState state)
	{
		init(new Location(x, y), state);
	}
	
	public Cell(Location location)
	{
		init(location, CellState.Dead);
	}
	
	public Cell(Location location, CellState state)
	{
		init(location, state);
	}
	
	public Location getLocation() 
	{
		return m_location;
	}
	
	public CellState getState() 
	{
		return m_state;
	}
	
	public boolean isAlive()
	{
		return m_state == CellState.Live;
	}

	public void setState(CellState m_state) {
		this.m_state = m_state;
	}
	
	@Override 
	public String toString() 
	{
		if(isAlive())
			return "Live(" + getLocation().toString() + ")";
		else
			return "Dead(" + getLocation().toString() + ")";
	}
	
	@Override
    public int hashCode() 
	{
        return m_location.hashCode();
    }
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Cell)
		{
			final Cell other = (Cell) obj;
			return (other.getLocation() == m_location && other.getState() == m_state);
		}
		return false;
	}
	
	
	// Private methods
	private void init(Location location, CellState state)
	{
		m_location = location;
		m_state = state;
	}

	private Location m_location;
	private CellState m_state;
}

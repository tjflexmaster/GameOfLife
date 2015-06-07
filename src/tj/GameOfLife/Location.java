package tj.GameOfLife;

/** Location is a two dimensional description of a physical location on a Game of Life GameBoard.
 * 	
 * @author TJ
 *
 */
public class Location {

	public Location(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
	
	public int getX() { return new Integer(m_x); }
	public int getY() { return new Integer(m_y); }
	
	@Override 
	public String toString() 
	{
		return Integer.toString(m_x) + "," + Integer.toString(m_y);
	}
	
	@Override
    public int hashCode() 
	{
        String uniqueLocation = Integer.toString(m_x) + "_" + Integer.toString(m_y);
        return uniqueLocation.hashCode();
    }
	
	@Override
	public boolean equals(Object obj)
	{
		final Location other = (Location) obj;
		return (other.m_x == m_x && other.m_y == m_y);
	}
	
	private int m_x;
	private int m_y;
}

package tj.GameOfLife;

import java.util.HashMap;
import java.util.HashSet;

public interface IGameBoard {
	
	public int getWidth();
	public int getHeight();
	
	public HashMap<Location, Cell> getLiveCells();
	public void setCells(HashSet<Cell> cells);
	public void setCell(Cell cell);
	public void clearCells();
	public HashSet<Location> getCellNeighborLocations(Cell cell) throws IllegalArgumentException;
	
	public void applyGameEngine(IGameEngine engine);
}

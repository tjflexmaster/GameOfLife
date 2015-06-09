package tj.GameOfLife;

import java.util.Map;
import java.util.Set;

public interface IGameBoard {
	
	public Integer getWidth();
	public Integer getHeight();
	
	public void getLiveCells(Map<GridLocation, GridCell> outputMap);
	
	public void setCells(Set<GridCell> cells);
	
	public void setCells(GridCell[] cells);
	
	public void setCell(GridCell cell);
	
	public void clearCells();
	
	public void getCellNeighborLocations(GridCell cell, Set<GridLocation> outputSet) 
			throws IllegalArgumentException;
	
	public void applyVisitor(IGameBoardVisitor visitor);
}

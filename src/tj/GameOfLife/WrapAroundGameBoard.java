package tj.GameOfLife;

import java.util.Set;

public class WrapAroundGameBoard extends GameBoard 
{
	
	public WrapAroundGameBoard(int width, int height) throws IllegalArgumentException
	{
		super(width, height);
	}

	@Override
	public void getCellNeighborLocations(GridCell cell,
			Set<GridLocation> outputSet) throws IllegalArgumentException 
	{
		if( !validCell(cell) )
			throw new IllegalArgumentException("Invalid cell location.  Cell must be found on the game board.");
		
		int row = cell.getLocation().getRow();
		int column = cell.getLocation().getColumn();
		int topNeighborRow = (row == topRow) ? bottomRow : row - 1;
		int bottomNeighborRow = (row == bottomRow) ? topRow : row + 1;
		int leftNeighborColumn = (column == leftColumn) ? rightColumn : column - 1;
		int rightNeighborColumn = (column == rightColumn) ? leftColumn : column + 1; 
		
		outputSet.add(new GridLocation(topNeighborRow, leftNeighborColumn));
		outputSet.add(new GridLocation(topNeighborRow, column));
		outputSet.add(new GridLocation(topNeighborRow, rightNeighborColumn));
		outputSet.add(new GridLocation(row, leftNeighborColumn));
		outputSet.add(new GridLocation(row, rightNeighborColumn));
		outputSet.add(new GridLocation(bottomNeighborRow, leftNeighborColumn));
		outputSet.add(new GridLocation(bottomNeighborRow, column));
		outputSet.add(new GridLocation(bottomNeighborRow, rightNeighborColumn));
		
	}

	@Override
	public void applyVisitor(IGameBoardVisitor visitor) 
	{
		visitor.visit(this);
	}

}

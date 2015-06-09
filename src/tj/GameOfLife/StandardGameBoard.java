package tj.GameOfLife;

import java.util.Set;

/** The Standard game board is a fixed grid of cells.
 * 	It must contain at least 1 cell.  Cells must be 
 * 	within the fixed grid to be valid.  Cell neighbors
 * 	are any cells that touch that cell, including
 * 	cells on the diagonals.  Cells in the middle of the
 * 	grid will have 8 neighbors.  Cells on the edges of
 * 	the grid will have 5 neighbors and cells in the 
 * 	corners of the grid have 3 neighbors.
 * 
 * @author TJ
 *
 */
public class StandardGameBoard extends GameBoard
{
	public StandardGameBoard(int width, int height) throws IllegalArgumentException
	{
		super(width, height);
	}
	
	@Override
	public void getCellNeighborLocations(GridCell cell, Set<GridLocation> outputSet) 
			throws IllegalArgumentException
	{
		if( !validCell(cell) )
		{
			throw new IllegalArgumentException("Invalid cell location.  Cell must be found on the game board.");
		}
		
		int row = cell.getLocation().getRow();
		int column = cell.getLocation().getColumn();
		
		if( row == topRow)
		{
			getTopRowCellNeighbors(column, outputSet);
		}
		else if( row == bottomRow)
		{
			getBottomRowCellNeighbors(column, outputSet);
		}
		else
		{
			getMiddleRowCellNeighbors(row, column, outputSet);
		}
	}
	
	@Override
	public void applyVisitor(IGameBoardVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	private void getTopRowCellNeighbors(int column, Set<GridLocation> outputSet)
	{
		if(column == leftColumn)
		{
			outputSet.add(new GridLocation(topRow, leftColumn + 1));
			outputSet.add(new GridLocation(topRow + 1, leftColumn + 1));
			outputSet.add(new GridLocation(topRow + 1, leftColumn));
		}
		else if(column == rightColumn)
		{
			outputSet.add(new GridLocation(topRow, rightColumn - 1));
			outputSet.add(new GridLocation(topRow + 1, rightColumn - 1));
			outputSet.add(new GridLocation(topRow + 1, rightColumn));
		}
		else
		{
			outputSet.add(new GridLocation(topRow, column - 1));
			outputSet.add(new GridLocation(topRow, column + 1));
			outputSet.add(new GridLocation(topRow + 1, column - 1));
			outputSet.add(new GridLocation(topRow + 1, column));
			outputSet.add(new GridLocation(topRow + 1, column + 1));
		}
	}
	
	private void getBottomRowCellNeighbors(int column, Set<GridLocation> outputSet)
	{
		if(column == leftColumn)
		{
			outputSet.add(new GridLocation(bottomRow, leftColumn + 1));
			outputSet.add(new GridLocation(bottomRow - 1, leftColumn + 1));
			outputSet.add(new GridLocation(bottomRow - 1, leftColumn));
		}
		else if(column == rightColumn)
		{
			outputSet.add(new GridLocation(bottomRow, rightColumn - 1));
			outputSet.add(new GridLocation(bottomRow - 1, rightColumn - 1));
			outputSet.add(new GridLocation(bottomRow - 1, rightColumn));
		}
		else
		{
			outputSet.add(new GridLocation(bottomRow, column - 1));
			outputSet.add(new GridLocation(bottomRow, column + 1));
			outputSet.add(new GridLocation(bottomRow - 1, column - 1));
			outputSet.add(new GridLocation(bottomRow - 1, column));
			outputSet.add(new GridLocation(bottomRow - 1, column + 1));
		}
	}
	
	private void getMiddleRowCellNeighbors(int row, int column, Set<GridLocation> outputSet)
	{
		if(column == leftColumn)
		{
			outputSet.add(new GridLocation(row - 1, leftColumn));
			outputSet.add(new GridLocation(row - 1, leftColumn + 1));
			outputSet.add(new GridLocation(row, leftColumn + 1));
			outputSet.add(new GridLocation(row + 1, leftColumn + 1));
			outputSet.add(new GridLocation(row + 1, leftColumn));
		}
		else if(column == rightColumn)
		{
			outputSet.add(new GridLocation(row - 1, rightColumn));
			outputSet.add(new GridLocation(row - 1, rightColumn - 1));
			outputSet.add(new GridLocation(row, rightColumn - 1));
			outputSet.add(new GridLocation(row + 1, rightColumn - 1));
			outputSet.add(new GridLocation(row + 1, rightColumn));
		}
		else
		{
			outputSet.add(new GridLocation(row - 1, column - 1));
			outputSet.add(new GridLocation(row - 1, column));
			outputSet.add(new GridLocation(row - 1, column + 1));
			outputSet.add(new GridLocation(row, column - 1));
			outputSet.add(new GridLocation(row, column + 1));
			outputSet.add(new GridLocation(row + 1, column - 1));
			outputSet.add(new GridLocation(row + 1, column));
			outputSet.add(new GridLocation(row + 1, column + 1));
		}
	}

}

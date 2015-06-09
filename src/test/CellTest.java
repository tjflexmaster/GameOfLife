package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tj.GameOfLife.GridCell;
import tj.GameOfLife.GridLocation;
import tj.GameOfLife.GridCell.CellState;

public class CellTest {

	@Test
	public void testHashCode_palindrome() {
		GridCell cell1 = new GridCell(1,21);
		GridCell cell2 = new GridCell(12,1);
		
		assertNotEquals(cell1.hashCode(), cell2.hashCode());
	}
	
	@Test
	public void testHashCode_same() {
		GridCell cell1 = new GridCell(new GridLocation(1,21));
		GridCell cell2 = new GridCell(new GridLocation(1,21));
		
		assertEquals(cell1.hashCode(), cell2.hashCode());
	}
	
	@Test
	public void testHashCode() {
		GridCell cell1 = new GridCell(new GridLocation(1,21));
		GridCell cell3 = cell1;
		
		assertEquals(cell1.hashCode(), cell3.hashCode());
	}
	
	@Test
	public void testGetState() {
		GridLocation loc1 = new GridLocation(1,1);
		GridCell cell1 = new GridCell(new GridLocation(1,1));
		
		assertEquals(cell1.getLocation(), loc1);
		assertEquals(cell1.getState(), CellState.Dead);
	}

	@Test
	public void testCellLocation() {
		GridLocation loc1 = new GridLocation(1,1);
		GridCell cell1 = new GridCell(new GridLocation(1,1));
		
		assertEquals(cell1.getLocation(), loc1);
		assertEquals(cell1.getState(), CellState.Dead);
	}

	@Test
	public void testCellLocationState() {
		GridLocation loc1 = new GridLocation(1,1);
		GridCell cell1 = new GridCell(new GridLocation(1,1), CellState.Live);
		
		assertEquals(cell1.getLocation(), loc1);
		assertEquals(cell1.getState(), CellState.Live);
	}

	@Test
	public void testSetState() {
		GridCell cell1 = new GridCell(new GridLocation(1,1), CellState.Live);
		assertEquals(cell1.getState(), CellState.Live);
		
		cell1.setState(CellState.Dead);
		assertEquals(cell1.getState(), CellState.Dead);
	}

	@Test
	public void testEqualsObject() {
		GridCell cell1 = new GridCell(new GridLocation(1,21));
		GridCell cell2 = new GridCell(new GridLocation(12,1));
		GridCell cell3 = cell1;
		
		assertNotEquals(cell1, cell2);
		assertEquals(cell1, cell3);
	}

}

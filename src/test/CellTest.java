package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tj.GameOfLife.Cell;
import tj.GameOfLife.Location;
import tj.GameOfLife.Cell.CellState;

public class CellTest {

	@Test
	public void testHashCode() {
		Cell cell1 = new Cell(new Location(1,21));
		Cell cell2 = new Cell(new Location(12,1));
		Cell cell3 = cell1;
		
		assertNotEquals(cell1.hashCode(), cell2.hashCode());
		assertEquals(cell1.hashCode(), cell3.hashCode());
	}

	@Test
	public void testCellLocation() {
		Location loc1 = new Location(1,1);
		Cell cell1 = new Cell(new Location(1,1));
		
		assertEquals(cell1.getLocation(), loc1);
		assertEquals(cell1.getState(), CellState.Dead);
	}

	@Test
	public void testCellLocationState() {
		Location loc1 = new Location(1,1);
		Cell cell1 = new Cell(new Location(1,1), CellState.Live);
		
		assertEquals(cell1.getLocation(), loc1);
		assertEquals(cell1.getState(), CellState.Live);
	}

	@Test
	public void testSetState() {
		Cell cell1 = new Cell(new Location(1,1), CellState.Live);
		assertEquals(cell1.getState(), CellState.Live);
		
		cell1.setState(CellState.Dead);
		assertEquals(cell1.getState(), CellState.Dead);
	}

	@Test
	public void testEqualsObject() {
		Cell cell1 = new Cell(new Location(1,21));
		Cell cell2 = new Cell(new Location(12,1));
		Cell cell3 = cell1;
		
		assertNotEquals(cell1, cell2);
		assertEquals(cell1, cell3);
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tj.GameOfLife.Location;

public class LocationTest {

	@Test
	public void testGetX() {
		Location loc1 = new Location(1, 21);
		
		assertEquals(loc1.getX(), 1);
	}
	
	@Test
	public void testGetY() {
		Location loc1 = new Location(1, 21);
		
		assertEquals(loc1.getY(), 21);
	}
	
	@Test
	public void testHashCode() {
		Location loc1 = new Location(1, 21);
		Location loc2 = new Location(21, 1);
		
		assertNotEquals(loc1.hashCode(), loc2.hashCode());
	}

	@Test
	public void testEqualsObject() {
		Location loc1 = new Location(1, 21);
		Location loc2 = new Location(21, 1);
		Location loc3 = loc1;
		
		assertNotEquals(loc1, loc2);
		assertEquals(loc1, loc3);
	}

}

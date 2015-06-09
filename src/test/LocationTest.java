package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tj.GameOfLife.GridLocation;

public class LocationTest {

	@Test
	public void testGetX() {
		GridLocation loc1 = new GridLocation(1, 21);
		
		assertEquals(loc1.getX(), 1);
	}
	
	@Test
	public void testGetY() {
		GridLocation loc1 = new GridLocation(1, 21);
		
		assertEquals(loc1.getY(), 21);
	}
	
	@Test
	public void testHashCode_same() {
		GridLocation loc1 = new GridLocation(1, 21);
		GridLocation loc2 = new GridLocation(1, 21);
		
		assertEquals(loc1.hashCode(), loc2.hashCode());
	}
	
	@Test
	public void testHashCode_palindrome() {
		GridLocation loc1 = new GridLocation(1, 21);
		GridLocation loc2 = new GridLocation(21, 1);
		
		assertNotEquals(loc1.hashCode(), loc2.hashCode());
	}

	@Test
	public void testEqualsObject_different() {
		GridLocation loc1 = new GridLocation(1, 21);
		GridLocation loc2 = new GridLocation(21, 1);
		
		assertNotEquals(loc1, loc2);
	}
	
	@Test
	public void testEqualsObject_same() {
		GridLocation loc1 = new GridLocation(1, 21);
		GridLocation loc2 = new GridLocation(1, 21);
		
		assertEquals(loc1, loc2);
	}
	
	@Test
	public void testEqualsObject_copy() {
		GridLocation loc1 = new GridLocation(1, 21);
		GridLocation loc3 = loc1;
		
		assertEquals(loc1, loc3);
	}

}

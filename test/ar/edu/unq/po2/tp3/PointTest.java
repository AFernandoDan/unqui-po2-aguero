package ar.edu.unq.po2.tp3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTest {
	Point aPoint;
	Point aZeroZeroPoint;
	Point otherPoint;
	
	@BeforeEach
	public void setUp() {
		aZeroZeroPoint = new Point();
		otherPoint = new Point(80, -5);
	}
	
	@Test
	public void aPointInitializesInZeroZero() {
		assertEquals(0, aZeroZeroPoint.getX());
		assertEquals(0, aZeroZeroPoint.getY());
	}
	
	@Test
	public void aPointInitializesAtGivenXAndYCoordinates() {
		aPoint = new Point(33,55);
		assertEquals(33, aPoint.getX());
		assertEquals(55, aPoint.getY());
	}
	
	@Test
	public void aPointMovesToAtGivenXAndYCoordinates() {
		aZeroZeroPoint.moveTo(10, 20);
		assertEquals(10, aZeroZeroPoint.getX());
		assertEquals(20, aZeroZeroPoint.getY());
	}
	
	@Test
	public void aPointAddsWithOtherPoint() {
		aPoint = new Point(-15, -5);
		aPoint.addWith(otherPoint);
		assertEquals(65, aPoint.getX());
		assertEquals(-10, aPoint.getY());
	}
}

package ar.edu.unq.po2.tp3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SquareTest {
	Square aSquare, otherSquare;
	
	@BeforeEach
	public void setUp() {
		Point firstPoint = new Point(0,0);
		Point secondPoint = new Point(10,-5);
		aSquare = new Square(firstPoint, 10);
		otherSquare = new Square(secondPoint, 10);
	}
	
	@Test
	public void theAreaOfASquareInZeroZeroWithTenSideIsOneHundered() {
		assertEquals(100, aSquare.getArea());
	}
	
	@Test
	public void thePerimeterOfASquareInZeroZeroWithTenSideIsForty() {
		assertEquals(40, aSquare.getPerimeter());
	}
}

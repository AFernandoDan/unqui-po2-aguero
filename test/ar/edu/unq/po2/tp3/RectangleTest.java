package ar.edu.unq.po2.tp3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RectangleTest {
	Rectangle aRectangle, otherRectangle;
	
	@BeforeEach
	public void setUp() {
		Point firstPoint = new Point(0,0);
		Point secondPoint = new Point(10,-5);
		aRectangle = new Rectangle(firstPoint, 20, 10);
		otherRectangle = new Rectangle(secondPoint, 5, 10);
	}
	
	@Test
	public void theAreaOfARectangleInZeroZeroWithTenHeightAndTwentyWidthIsTwoHundered() {
		assertEquals(200, aRectangle.getArea());
	}
	
	@Test
	public void thePerimeterOfARectangleInZeroZeroWithTenHeightAndTwentyWidthIsTwoHundered() {
		assertEquals(60, aRectangle.getPerimeter());
	}
	
	@Test
	public void theRectangleInZeroZeroWithTenHeightAndTwentyWidthIsVertical() {
		assert(aRectangle.isVertical());
		assertFalse(aRectangle.isHorizontal());
	}
	
	@Test
	public void theRectangleInTenWithTenHeightAndFiveWidthIsHorizontal() {
		assert(otherRectangle.isHorizontal());
		assertFalse(otherRectangle.isVertical());
	}
}

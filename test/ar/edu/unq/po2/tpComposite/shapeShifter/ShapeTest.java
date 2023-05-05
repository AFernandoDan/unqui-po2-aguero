package ar.edu.unq.po2.tpComposite.shapeShifter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShapeTest {
	private Shape aShape;

	@BeforeEach
	public void setUp() {
		aShape = new Shape(1);
	}
	
	@Test
	public void aShapeHasValues() {
		LinkedList<Integer> expectedValues = new LinkedList<Integer>(Arrays.asList(1));
		assertEquals(expectedValues, aShape.values());
	}
	
	@Test
	public void aShapeHasADepthOfZero() {
		assertEquals(0, aShape.deepest());
	}
	
	@Test
	public void aFlatedShapeIsEqualsToSelf() {
		assertEquals(aShape, aShape.flat());
	}
	
	@Test
	public void aShapeComposedWithOtherShapeIsEqualsToACompositeShape() {
		IShapeShifter otherShape = mock(IShapeShifter.class);
		CompositeShape expectedShape = mock(CompositeShape.class);
//		assertEquals(expectedShape, aShape.compose(otherShape));
//		preguntar como verificar que este test salio bien
	}
	
	@Test
	public void aShapeIsEqualToOtherShapeIfHasTheSameValues() {
		Shape otherShape = mock(Shape.class);
		when(otherShape.values()).thenReturn( new LinkedList<Integer>(Arrays.asList(1)));
		
		assertEquals(aShape, otherShape);
		
		when(otherShape.values()).thenReturn( new LinkedList<Integer>(Arrays.asList(2)));
		assertNotEquals(aShape, otherShape);
	}

}

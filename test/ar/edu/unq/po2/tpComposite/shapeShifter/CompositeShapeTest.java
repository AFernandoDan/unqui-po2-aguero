package ar.edu.unq.po2.tpComposite.shapeShifter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompositeShapeTest {
	private IShapeShifter shapeShifterA, shapeShifterB, shapeShifterC;
	private CompositeShape aCompositeShape, emptyCompositeShape;

	@BeforeEach
	public void setUp() {
		shapeShifterA = mock(IShapeShifter.class);
		when(shapeShifterA.deepest()).thenReturn(0);
		when(shapeShifterA.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(5,6)));
		
		shapeShifterB = mock(IShapeShifter.class);
		when(shapeShifterB.deepest()).thenReturn(2);
		
		shapeShifterC = mock(IShapeShifter.class);
		when(shapeShifterC.deepest()).thenReturn(3);
		when(shapeShifterC.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(3,2)));
		aCompositeShape = new CompositeShape(shapeShifterA, shapeShifterB);
		emptyCompositeShape = new CompositeShape();
		
	}
	
	@Test
	public void theValuesOfAEmptyCompositeShapeIsAEmptyList() {
		LinkedList<IShapeShifter> expectedValues = new LinkedList();
		assertEquals(expectedValues, emptyCompositeShape.values());
	}
	
	// preguntar: ¿Cual es la altura en un CompositeShape vacio?
	
	@Test
	public void theDepthOfACompositeShapeIsThatOfTheDeepestPartPlusOne() {
		assertEquals(3, aCompositeShape.deepest());
		verify(shapeShifterA).deepest();
		verify(shapeShifterA, times(1)).deepest();
		verify(shapeShifterB, times(2)).deepest();
	}
	
	@Test
	public void addAIShapShifterToACompositeShape() {
		aCompositeShape.add(shapeShifterC);
		aCompositeShape.add(shapeShifterC);
		
		assertEquals(4, aCompositeShape.deepest());
	}
	
	@Test
	public void theValuesOfACompositeShapeAreTheValuesOfAllItsShapes() {
		emptyCompositeShape.add(shapeShifterA);
		emptyCompositeShape.add(shapeShifterC);
		
		LinkedList<Integer> expectedValues = new LinkedList<Integer>(Arrays.asList(5,6,3,2));
		assertEquals(expectedValues, emptyCompositeShape.values());
	}
	
	@Test
	public void aCompositeShapeIsEqualToOtherIfHasSameValuesAndSameDeepest() {
		Shape shapeA = mock(Shape.class);
		when(shapeA.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(10)));
		
		Shape shapeB = mock(Shape.class);
		when(shapeB.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(20)));

		
		CompositeShape compositeAB = new CompositeShape(shapeA, shapeB);
		
		CompositeShape compositeBA = new CompositeShape(shapeB, shapeA);
		
		assertEquals(compositeAB, compositeBA);
	}
	
	@Test
	public void flattingACompositeShape() {
		Shape shapeA = mock(Shape.class);
		when(shapeA.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(10)));
		
		Shape shapeB = mock(Shape.class);
		when(shapeB.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(20)));
		
		Shape shapeC = mock(Shape.class);
		when(shapeC.values()).thenReturn(new LinkedList<Integer>(Arrays.asList(30)));
		
		CompositeShape compositeBC = new CompositeShape(shapeB, shapeC);
		
		CompositeShape expectedShape = new CompositeShape(shapeA, shapeB);
		expectedShape.add(shapeC);
		
		emptyCompositeShape.add(shapeA);
		emptyCompositeShape.add(compositeBC);
		
		assertEquals(expectedShape, emptyCompositeShape.flat());
		assertEquals(emptyCompositeShape.flat().deepest(), 1);
	}
}

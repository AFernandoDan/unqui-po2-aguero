package ar.edu.unq.po2.tpComposite.shapeShifter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CompositeShape implements IShapeShifter {

	private LinkedList<IShapeShifter> childShapes;

	public CompositeShape(IShapeShifter shapeA, IShapeShifter shapeB) {
		setShapes(new LinkedList<IShapeShifter>(Arrays.asList(shapeA, shapeB)));
	}

	public CompositeShape() {
		setShapes(new LinkedList<IShapeShifter>());
	}

	@Override
	public IShapeShifter compose(IShapeShifter shapeShifter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deepest() {
		return 1 + getDeepestShape().deepest();
	}

	private IShapeShifter getDeepestShape() {
		return Collections.max(getShapes(), Comparator.comparing(IShapeShifter::deepest));
	}

	private List<IShapeShifter> getShapes() {
		return childShapes;
	}
	
	private void setShapes(LinkedList<IShapeShifter> shapes) {
		this.childShapes = shapes;
	}

	@Override
	public IShapeShifter flat() {
		CompositeShape flattenShape = new CompositeShape();
		values().forEach(v -> {
			flattenShape.add(new Shape(v));
		});
		return flattenShape;
	}

	@Override
	public List<Integer> values() {
		return getShapes().stream().map(s -> s.values()).flatMap(Collection::stream).toList();
	}

	public void add(IShapeShifter shapeShifter) {
		getShapes().add(shapeShifter);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof CompositeShape && hasSameValuesAndDeepest((CompositeShape) obj))
			res = true;
		return res;
	}

	private boolean hasSameValuesAndDeepest(CompositeShape compositeShape) {
		return
			values().containsAll(compositeShape.values()) &&
			deepest() == compositeShape.deepest();
	}

}

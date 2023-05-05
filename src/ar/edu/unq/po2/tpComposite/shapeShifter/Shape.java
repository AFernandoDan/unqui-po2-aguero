package ar.edu.unq.po2.tpComposite.shapeShifter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Shape implements IShapeShifter {

	private LinkedList<Integer> values;
	
	public Shape(int value) {
		setValues(new LinkedList<Integer>(Arrays.asList(value)));
	}

	@Override
	public IShapeShifter compose(IShapeShifter shapeShifter) {
		return new CompositeShape(this, shapeShifter);
	}

	@Override
	public int deepest() {
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		return this;
	}

	public void setValues(LinkedList<Integer> values) {
		this.values = values;
	}

	@Override
	public List<Integer> values() {
		return values;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof Shape && this.hasSameValue((Shape) obj))
			res = true;
		return res;
	}

	private boolean hasSameValue(Shape aShape) {
		return this.values().containsAll(aShape.values());
	}

}

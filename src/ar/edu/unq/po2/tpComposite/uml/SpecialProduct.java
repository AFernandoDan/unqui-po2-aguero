package ar.edu.unq.po2.tpComposite.uml;

public class SpecialProduct extends Product{
	public SpecialProduct(String name, float price) {
		super(name, price);
	}
	
	@Override
	public float getPrice() {
		// aca deberia hacer algo para redefinir getPrice
		// pero pongo cero porque no se detalla que hace el metodo.
		return 0;
	}
}

package ar.edu.unq.po2.tpTemplateMethodYAdapter.ventana;

import javax.swing.DefaultListModel;

public class ListaDePalabrasOrdenadasAdapter<E> extends DefaultListModel<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ListaDePalabrasOrdenadas lpo;
	
	public ListaDePalabrasOrdenadasAdapter() {
		lpo = new ListaDePalabrasOrdenadas();
	}
	
	@Override
	public void addElement(E element) {
		lpo.agregarPalabra((String) element);
	}
	
	@Override
    public int getSize() {
        return lpo.cantidadDePalabras();
    }
	
	@Override
    public E getElementAt(int index) {
        return (E) lpo.getPalabraDePosicion(index);
    }
}

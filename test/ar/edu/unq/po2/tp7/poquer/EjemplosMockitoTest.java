package ar.edu.unq.po2.tp7.poquer;

import org.junit.Test;

import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EjemplosMockitoTest {

    @Test
    public void testDeEjemploDeVerificacionEnOrdenDelEnvioDeMensajes() {
    	
        List<String> mockedList = mock(List.class);

        // Usar el objeto mock de la lista
        mockedList.add("algo");
        mockedList.clear();
        
        InOrder inOrder = Mockito.inOrder(mockedList);

        // Verficando las interacciones con el mock 
        inOrder.verify(mockedList).add("algo");
        inOrder.verify(mockedList).clear();
    }
    
    @Test
    public void testDeEjemploDeVerificacionDeRecepcionDeMensajesSinObligacionDeQueHayanSidoEnviados() {
    	// Crear objeto mock de una lista
    	List<String> mockedList = mock(List.class);

    	// Usar el objeto mock de la lista en cualquier orden
    	mockedList.clear();
    	mockedList.add("one");

    	// Verificar que los métodos fueron llamados al menos 0 veces (es decir, no importa si fueron llamados o no)
    	verify(mockedList, atLeast(0)).add("one");
    	verify(mockedList, atLeast(0)).clear();
    }
    
    @Test
    public void testDeEjemploDeMocksConMensajesAnidados() {
    	// Crear objeto mock para un objeto anidado
    	ArrayList<Carta> mockLista = mock(ArrayList.class);

    	// Crear objeto mock para un objeto que contiene al objeto anidado
    	Carta mockCarta = mock(Carta.class);

    	// Configurar el comportamiento del método get(0) del objeto mockFoo para devolver el objeto mockCarta
    	when(mockLista.get(0)).thenReturn(mockCarta);

    	// Llamar al método get(0) del objeto mockLista y luego llamar al método getValor() del objeto mockCarta
    	mockLista.get(0).getValor();

    	// Verificar que los métodos fueron llamados
    	verify(mockLista).get(0);
    	verify(mockCarta).getValor();
    }
}
package upc.poo;

import org.junit.Assert;
import org.junit.Test;

public class VentaCTRLTest {
    
    VentaCTRL ventas = new VentaCTRL();
    
    @Test
    public void DeboTenerUnArregloDeVentas() {
        Assert.assertNotNull(ventas.getVentas());
    }

    @Test
    public void DeboPoderAgregarUnaVenta() {
        Venta venta1 = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 200.00, "dolares", "Falta enviar comprobante al cliente");
        ventas.nuevaVenta(venta1);
        Assert.assertEquals(ventas.getVentas().size(), 1);
    }

    
    
}

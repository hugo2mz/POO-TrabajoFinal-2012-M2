package upc.poo.controller;

import upc.poo.controller.VentaCTRL;
import upc.poo.model.Venta;
import java.text.SimpleDateFormat;
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

    @Test
    public void DeboPoderMostrarElListadoCompletoDeLasVentasGeneradas() {
        Venta venta1 = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 200.00, "dolares", "Falta enviar comprobante al cliente");
        Venta venta2 = new Venta(".NET", "Factura", "001-002", "Z TEc", "19-03-2009", "18-04-2009", "21-03-2009", "cancelada", 300.00, "dolares", "Enviar Factura a partir de abril");
        Venta venta3 = new Venta("Drupal", "Boleta", "001-003", "", "29-04-2010", "30-04-2010", "30-04-2010", "cancelada", 100.00, "dolares", "Enviar Boleta a domicilio");
        Venta venta4 = new Venta("C#", "Factura", "001-004", "SyslogSA", "29-04-2011", "30-04-2011", "30-04-2011", "cancelada", 250.00, "dolares", "Enviar via DHL");
        
        //ventas.formatearVentas();
        ventas.nuevaVenta(venta1);
        ventas.nuevaVenta(venta2);
        ventas.nuevaVenta(venta3);
        ventas.nuevaVenta(venta4);

        for(int i = 0; i< ventas.getVentas().size();i++) {
            System.out.println( 
                            new SimpleDateFormat("dd-MM-yyyy").format(ventas.getVentas().get(i).getFechaVencimiento()) + "   " +
                            ventas.getVentas().get(i).getEmpresa() + "   " + 
                            ventas.getVentas().get(i).getConcepto() + "   " + 
                            ventas.getVentas().get(i).getTipoDocumento() + "   " +
                            ventas.getVentas().get(i).getNumero() + "   "  +
                            ventas.getVentas().get(i).getEstado() + "   " +
                            ventas.getVentas().get(i).getMoneda() + "   " +
                            ventas.getVentas().get(i).getObservaciones() + "   " +
                            ventas.getVentas().get(i).getSubtotal() + "   "  +
                            ventas.getVentas().get(i).getIgv() + "   "  +
                            ventas.getVentas().get(i).getTotal() + "   "  +           
                        "");
        }
        Assert.assertEquals(ventas.getVentas().size(), 4);
    }    

    @Test
    public void DeboPoderCalcularElIgvDeLaVenta() {        
        Venta venta1 = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 100.00, "dolares", "Falta enviar comprobante al cliente");
        Assert.assertEquals(19, venta1.getIgv(),0.0);        
    }

    @Test
    public void DeboPoderCalcularElTotalDeLaVenta() {        
        Venta venta1 = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 100.00, "dolares", "Falta enviar comprobante al cliente");
        Assert.assertEquals(118.00, venta1.getTotal(),0.0);        
    }
    
    
}

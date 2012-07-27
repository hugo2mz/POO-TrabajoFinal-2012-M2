package upc.poo;

import junit.framework.Assert;
import org.junit.Test;

public class GrupoDeEstudioTest {

    @Test
    public void DebeExistirLaClaseVentaYNoSerNull1 () {
        GrupoDeEstudio grupoestudio = new GrupoDeEstudio();
        Assert.assertNotNull(grupoestudio); 
    }
    
    /*
    @Test
    public void DebeExistirLaClaseVentaYNoSerNull2 () {
    //String concepto, String tipoDocumento, String numero, String empresa, String fechaEmision, String fechaVencimiento, String fechaPago, String estado, double subtotal, String moneda, String observaciones
        Venta venta = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 200.00, "dolares", "...");
        Assert.assertNotNull(venta); 
    }
    * 
    */
            
}

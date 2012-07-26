package upc.poo;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class VentaTest {
    
//String concepto, String tipoDocumento, String numero, String empresa, String fechaEmision, String fechaVencimiento, String fechaPago, String estado, double subtotal, String moneda, String observaciones
    @Test
    public void DebeExistirLaClaseVentaYNoSerNull () {
        Venta venta = new Venta("Java SE", "Factura", "001-001", "ABS Soluciones", "11-06-2009", "11-07-2009", "30-06-2009", "cancelada", 200.00, "dolares", "...");
        Assert.assertNotNull(venta); 
    }

    
}

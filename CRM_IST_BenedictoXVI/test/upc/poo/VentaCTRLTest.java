package upc.poo;

import org.junit.Assert;
import org.junit.Test;

public class VentaCTRLTest {
    
    VentaCTRL ventas = new VentaCTRL();
    
    @Test
    public void DeboTenerUnArregloDeVentas() {
        Assert.assertNotNull(ventas.getVentas());
    }

}

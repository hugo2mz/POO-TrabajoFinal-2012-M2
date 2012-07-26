package upc.poo;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ClienteTest {
    
    public ClienteTest() {
    }

    @Test
    public void DebeExistirLaClaseClienteYNoSerNull () {
        Cliente cliente = new Cliente("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2011");
        Assert.assertNotNull(cliente); 
    }

}

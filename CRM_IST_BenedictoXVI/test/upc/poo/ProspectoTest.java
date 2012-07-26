package upc.poo;

import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ProspectoTest {
    
    //Prospecto prospecto = new Prospecto();

    @Test
    public void DebeExistirLaClaseProspectoYNoSerNull () {
        Prospecto prospecto = new Prospecto("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2011");
        Assert.assertNotNull(prospecto); 
    }

    /*
    @Test
    public void prospectoDebeTenerDatos() {
        Prospecto prospecto = new Prospecto("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456",  "17-05-2011");
        Assert.assertEquals("Jacinto", prospecto.getNombres());
        Assert.assertEquals("Martinez", prospecto.getaPaterno());
        Assert.assertEquals("Garay", prospecto.getaMaterno());
        Assert.assertEquals("jmartinez@movistar.pe", prospecto.getEmail());
        Assert.assertEquals("12345678", prospecto.getDni());
        Assert.assertEquals("6578746", prospecto.getTelefono());
        Assert.assertEquals("20120211", prospecto.getFechaContacto());       
    }
    * 
    */

}
package upc.poo;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ProspectoCTRLTest {
    
    ProspectoCTRL prospectos = new ProspectoCTRL();
    
    @Test
    public void DeboTenerUnArregloDeProspectos() {        
        Assert.assertNotNull(prospectos.getProspectos());
    }
    
    @Test
    public void DeboPoderAgregarUnProspecto(){
        Prospecto prospecto1 = new Prospecto("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2009");
        prospectos.nuevoProspecto(prospecto1);
        Assert.assertEquals(prospectos.getProspectos().size(), 1);
    }

    @Test
    public void DeboPoderMostrarElListadoDeProspectos() {
        Prospecto prospecto1 = new Prospecto("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2009");
        Prospecto prospecto2 = new Prospecto("Oscar", "Romero", "Canales", "oromero@tt.pe", "32345699", "999123456", "09-02-2011");
        Prospecto prospecto3 = new Prospecto("Carlos", "Bustamante", "Torres", "cbusta@domino.pe", "42345688", "988123456", "10-09-2010");
        Prospecto prospecto4 = new Prospecto("Javier", "Garcia", "C", "jgarcia@bvn.pe", "42345677", "977123456", "01-07-2012");
        //prospectos.formatearProspectos();
        prospectos.nuevoProspecto(prospecto1);
        prospectos.nuevoProspecto(prospecto2);
        prospectos.nuevoProspecto(prospecto3);
        prospectos.nuevoProspecto(prospecto4);
        

        
        Assert.assertEquals(prospectos.getProspectos().size(), 4);
    }    
    
    
}

package upc.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Prospecto prospecto1 = new Prospecto("Mario", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2009");
        prospectos.nuevoProspecto(prospecto1);
        Assert.assertEquals(prospectos.getProspectos().size(), 1);
    }

    @Test
    public void DeboPoderMostrarElListadoCompletoDeProspectosIngresados() {
        Prospecto prospecto1 = new Prospecto("Jacinto", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "987123456", "17-05-2011");
        Prospecto prospecto2 = new Prospecto("Oscar", "Romero", "Canales", "oromero@tt.pe", "32345699", "999123456", "09-02-2009");
        Prospecto prospecto3 = new Prospecto("Carlos", "Bustamante", "Torres", "cbusta@domino.pe", "42345688", "988123456", "10-09-2010");
        Prospecto prospecto4 = new Prospecto("Javier", "Garcia", "C.", "jgarcia@bvn.pe", "42345677", "977123456", "30-06-2012");
        Prospecto prospecto5 = new Prospecto("Dante", "Pimentel", "S.", "dpimentel@gy.pe", "42345666", "966123466", "11-07-2012");
        
        //prospectos.formatearProspectos();
        prospectos.nuevoProspecto(prospecto1);
        prospectos.nuevoProspecto(prospecto2);
        prospectos.nuevoProspecto(prospecto3);
        prospectos.nuevoProspecto(prospecto4);
        prospectos.nuevoProspecto(prospecto5);

        for(int i = 0; i< prospectos.getProspectos().size();i++) {
            System.out.println(                            
                            new SimpleDateFormat("dd-MM-yyyy").format(prospectos.getProspectos().get(i).getFechaContacto()) + "   " +
                            prospectos.getProspectos().get(i).getDni() + "   " + 
                            prospectos.getProspectos().get(i).getNombres() + "   " + 
                            prospectos.getProspectos().get(i).getaPaterno() + "   " +
                            prospectos.getProspectos().get(i).getaMaterno() + "   " +
                            prospectos.getProspectos().get(i).getTelefono() + "   " +
                            prospectos.getProspectos().get(i).getEmail() + "   "    
                        );
        }
        Assert.assertEquals(prospectos.getProspectos().size(), 5);
    }    
    
    
}

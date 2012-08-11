package upc.poo;

import upc.poo.controller.AlumnoCTRL;
import upc.poo.model.Alumno;
import java.text.SimpleDateFormat;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class AlumnoCTRLTest {
    
    AlumnoCTRL clientes = new AlumnoCTRL();
    
    /*
    @Test
    public void DeboTenerUnArregloDeClientes() {        
        Assert.assertNotNull(clientes.getClientes());
    }
    
    @Test
    public void DeboPoderAgregarUnCliente() {
//String nombres, String aPaterno, String aMaterno, String email, String dni, String telefono, String celular, String flagTipoCliente, String strFechaContacto, String strFechaCliente
        Cliente cliente1 = new Cliente("12345678", "Mario", "Martinez", "Garay", "jmartinez@movistar.pe", "520-5432", "987123456", "P", "17-05-2009", "");
        clientes.nuevoCliente(cliente1);
        Assert.assertEquals(clientes.getClientes().size(), 1);
    }

    @Test
    public void DeboPoderMostrarElListadoCompletoDeClientesIngresados() {
        Cliente cliente1 = new Cliente("Mario", "Martinez", "Garay", "jmartinez@movistar.pe", "12345678", "520-5432", "987123456", "P", "17-05-2009", "");
        Cliente cliente2 = new Cliente("José", "Rodríguez", "Poma", "jpma@tt.pe", "12345679", "528-5431", "987123411", "P", "27-09-2008", "");
        Cliente cliente3 = new Cliente("Andrés", "Ramos", "Huaita", "hramos@todsa.pe", "12345670", "613-5439", "987123422", "P", "19-02-2010", "");
        Cliente cliente4 = new Cliente("Enrique", "Salas", "Taipe", "esalas@jalo.com.pe", "12345611", "719-5430", "987123433", "P", "01-10-2011", "");
        Cliente cliente5 = new Cliente("Manuel", "Montoya", "Santos", "mmontoya@loisa.com.pe", "12345622", "640-5431", "987123444", "P", "11-09-2012", "");
        Cliente cliente6 = new Cliente("Javier", "Rojas", "Meza", "jrojas@comteperu.com", "12345633", "756-5432", "987123455", "P", "29-04-2011", "");
        Cliente cliente7 = new Cliente("Antero", "Melgar", "Chaparro", "amelgar@ddes.com", "12345644", "799-5433", "987123466", "P", "31-03-2012", "");
        
        clientes.nuevoCliente(cliente1);
        clientes.nuevoCliente(cliente2);
        clientes.nuevoCliente(cliente3);
        clientes.nuevoCliente(cliente4);
        clientes.nuevoCliente(cliente5);
        clientes.nuevoCliente(cliente6);
        clientes.nuevoCliente(cliente7);
        
        for(int i = 0; i< clientes.getClientes().size();i++) {
            System.out.println(                            
                            new SimpleDateFormat("dd-MM-yyyy").format(clientes.getClientes().get(i).getFechaContacto()) + "   " +
                            clientes.getClientes().get(i).getDni() + "   " + 
                            clientes.getClientes().get(i).getNombres() + "   " + 
                            clientes.getClientes().get(i).getaPaterno() + "   " +
                            clientes.getClientes().get(i).getaMaterno() + "   " +
                            clientes.getClientes().get(i).getTelefono() + "   " +
                            clientes.getClientes().get(i).getEmail() + "   "    +
                            clientes.getClientes().get(i).getFlagTipoCliente() + "   "    
                        );
        }
        Assert.assertEquals(clientes.getClientes().size(), 7);        
    }
    * 
    */
    
}

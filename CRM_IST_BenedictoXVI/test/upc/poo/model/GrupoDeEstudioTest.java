package upc.poo;

import junit.framework.Assert;
import org.junit.Test;

public class GrupoDeEstudioTest {

    @Test
    public void DebeExistirLaClaseGrupoDeEstudioYNoSerNull1 () {
        GrupoDeEstudio grupoestudio = new GrupoDeEstudio();
        Assert.assertNotNull(grupoestudio); 
    }
    
    @Test
    public void DebeExistirLaClaseGrupoDeEstudioYNoSerNull2 () {    
        GrupoDeEstudio grupoestudio = new GrupoDeEstudio("Grupo Telefonica Centrales", "12-07-2012", "22-07-2012");
        Assert.assertNotNull(grupoestudio); 
    }
            
}

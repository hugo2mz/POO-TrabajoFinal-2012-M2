package upc.poo;

import java.util.*;

public class ProspectoCTRL implements Comparator {
    private ArrayList<Prospecto> prospectos = new ArrayList<Prospecto>();

    public ArrayList<Prospecto> getProspectos() {
        Collections.sort(prospectos, new ProspectoCTRL());
        return prospectos;   //retorna el array prospectos completo, ordenado por fecha
    }

    public void nuevoProspecto(Prospecto prospecto) {
        prospectos.add(prospecto);    //agrega un prospecto al array de prospectos
    }    
    
    public void formatearProspectos() {
        prospectos.clear();    //OJO: Solo para pruebas: Elimina todos los prospectos
    }    

    double getTotal() {
        double total = 0.0;
        for(int i = 0; i< prospectos.size();i++){
            //total +=  this.prospectos.get(i).getImpuesto();
        }
        return total;
    }

    public int compare(Object o1, Object o2) { 
        Prospecto prospecto1 = (Prospecto) o1;
        Prospecto prospecto2 = (Prospecto) o2;        
        return prospecto1.getFechaContacto().compareTo(prospecto2.getFechaContacto());
    }     
}

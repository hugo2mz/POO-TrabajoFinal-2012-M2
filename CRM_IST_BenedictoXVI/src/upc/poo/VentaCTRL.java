package upc.poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class VentaCTRL implements Comparator {

    private ArrayList<Venta> ventas = new ArrayList<Venta>();

    public ArrayList<Venta> getVentas() {
        Collections.sort(ventas, new VentaCTRL());
        return ventas;   //retorna el array ventas completo, ordenado por fecha de vencimiento
    }

    public void nuevoProspecto(Venta venta) {
        ventas.add(venta);    //agrega una Venta al array de ventas
    }    
    
    
    public int compare(Object o1, Object o2) { //Difinir el ordenamiento
        Venta venta1 = (Venta) o1;
        Venta venta2 = (Venta) o2;        
        return venta1.getFechaVencimiento().compareTo(venta2.getFechaVencimiento());
    }
}

package upc.poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Venta {
    private String concepto;
    private String tipoDocumento;
    private String numero;
    private String empresa;
    private Date fechaEmision;    
    private Date fechaVencimiento;
    private Date fechaPago;
    private String estado;
    private double subtotal;
    private double igv;
    private double total;
    private String moneda;
    private String observaciones;
    
    public Venta() {
    }
    
    public Venta(String concepto, String tipoDocumento, String numero, String empresa, String fechaEmision, String fechaVencimiento, String fechaPago, String estado, double subtotal, String moneda, String observaciones) {
        this.concepto = concepto;
        this.tipoDocumento = tipoDocumento;
        this.numero = numero;
        this.empresa = empresa;
        this.estado = estado;
        this.subtotal = subtotal;
        //this.igv = igv;
        //this.total = total;
        this.moneda = moneda;
        this.observaciones = observaciones;
        
        calcularIgv();
        calcularTotal();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.fechaEmision = formatoFecha.parse(fechaEmision);
            this.fechaVencimiento = formatoFecha.parse(fechaVencimiento);
            this.fechaPago = formatoFecha.parse(fechaPago);            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public String getConcepto() {
        return concepto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getNumero() {
        return numero;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }
    

    public double getSubtotal() {
        return subtotal;
    }

    public double getIgv() {
        return igv;
    }
    
    public double getTotal() {
        return total;
    }

    
    private void calcularIgv() {
        igv = subtotal * 0.18;           
    }
      
    private void calcularTotal() {
        total = subtotal + igv;           
    }

}

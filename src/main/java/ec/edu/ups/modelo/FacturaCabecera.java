/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 *
 * @author Diego Duchimaza
 */
@Entity
public class FacturaCabecera implements  Serializable{
    private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Date fecha;
    private double iva;
    private double subTotal;
    private double total;
   
    @ManyToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "facturaCabecera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> facturaDetalles;

    public FacturaCabecera() {
        this.facturaDetalles = new ArrayList<>();
        this.iva = 0.12;
    }

    public FacturaCabecera(Date fecha,double total, Usuario usuario, List<FacturaDetalle> facturaDetalles) {
        this.fecha = fecha;
        this.total = total;
        this.usuario = usuario;
        this.facturaDetalles = facturaDetalles;
        this.iva = 0.12;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        this.total = this.subTotal*this.iva;
        return this.total;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<FacturaDetalle> getFacturaDetalles() {
        return facturaDetalles;
    }

    public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }
    
    public double getSubTotal() {
        double sum = 0;
        for(FacturaDetalle fd : this.facturaDetalles)
                sum += fd.getSubtotal();
        this.subTotal = sum;
        
        return this.subTotal;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacturaCabecera other = (FacturaCabecera) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
      
        return true;
    }
    
    public void addFacturaDetalle(FacturaDetalle facturaDetalle) {
        if (!this.facturaDetalles.contains(facturaDetalle)) {
            this.facturaDetalles.add(facturaDetalle);
            facturaDetalle.setFacturaCabecera(this);
        }
    }

    public void deleteFacturaDetalle(FacturaDetalle facturaDetalle) {
        if (this.facturaDetalles.contains(facturaDetalle)) {
            this.facturaDetalles.remove(facturaDetalle);
            facturaDetalle.setFacturaCabecera(null);
        }
    }
       
}

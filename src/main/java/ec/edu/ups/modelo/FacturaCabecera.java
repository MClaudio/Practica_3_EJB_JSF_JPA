/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 *
 * @author Diego Duchimaza
 */
@Entity
public class FacturaCabecera implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private Date fecha;
    private double iva;
    private double total;
   
    @ManyToOne
    private Usuario usuario;
    
    @OneToMany(mappedBy = "facturaCabecera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> facturaDetalles;

    public FacturaCabecera() {
    }

    public FacturaCabecera(int codigo, Date fecha, double iva, double total, Usuario usuario, List<FacturaDetalle> facturaDetalles) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
        this.usuario = usuario;
        this.facturaDetalles = facturaDetalles;
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
        return total;
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

    @Override
    public String toString() {
        return "FacturaCabecera{" + "codigo=" + codigo + ", fecha=" + fecha + ", iva=" + iva + ", total=" + total + ", usuario=" + usuario + ", facturaDetalles=" + facturaDetalles + '}';
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
    
    
    
}

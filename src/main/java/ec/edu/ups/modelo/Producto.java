/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
 * @author criss
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String nombre;

    private String imagen;

    private double precio;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> facturasDetalles;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventario> inventarios;
    
    @ManyToOne
    private Categoria categoria;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String imagen, double precio, List<FacturaDetalle> facturasDetalles, List<Inventario> inventarios, Categoria catorias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.facturasDetalles = facturasDetalles;
        this.inventarios = inventarios;
        this.categoria = catorias;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<FacturaDetalle> getFacturasDetalles() {
        return facturasDetalles;
    }

    public void setFacturasDetalles(List<FacturaDetalle> facturasDetalles) {
        this.facturasDetalles = facturasDetalles;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void addInventario(Inventario inventario){
        if(!this.inventarios.contains(inventario)){
            this.inventarios.add(inventario);
            inventario.setProducto(this);
        }
    }
    
     public void deleteInventario(Inventario inventario) {
        if (this.inventarios.contains(inventario)) {
            this.inventarios.remove(inventario);
            inventario.setProducto(null);
        }
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
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
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    

}

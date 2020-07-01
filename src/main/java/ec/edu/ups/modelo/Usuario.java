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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Diego Duchimaza
 */
@Entity
public class Usuario implements  Serializable{
    
    @Id
    private int cedula;
    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false)
    private String correo;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'cliente'")
    private String rol;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaCabecera> facturas;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Localidad> localidad;
    
    public Usuario(){
        
    }

    public Usuario(int cedula, String nombre, String apellido, String correo, String password, String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<FacturaCabecera> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaCabecera> facturas) {
        this.facturas = facturas;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<Localidad> getLocalidad() {
        return localidad;
    }

    public void setLocalidad(List<Localidad> localidad) {
        this.localidad = localidad;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.cedula;
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
        final Usuario other = (Usuario) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password + ", facturas=" + facturas + ", rol=" + rol + '}';
    }  
    
}

package ec.edu.ups.controlador;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Localidad;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author criss
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "bodegaBean")
@SessionScoped
public class BodegaBean implements Serializable  {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private BodegaFacade bodegaFacade;
    private String Ciudad;
    private String direccion;
    private String nombre;
    private String pais;
    private String provincia;
    private String telefono;
    private List<Bodega> bodegas;
    

    public BodegaBean() {
    }
    
    @PostConstruct
    public void init() {
        try {
            this.bodegas = bodegaFacade.findAll();
        } catch (Exception e) {
            System.out.println("Error---"+e);
        }
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }
    
    public void guardarDatos(){
        Bodega bodega =new Bodega();
        
        bodega.setNombre(this.nombre);
        Localidad localidad = new Localidad(this.Ciudad, this.direccion, this.pais, this.provincia, this.telefono);
        bodega.setLocalidad(localidad);
 
        System.out.println("Bodegaaaaaaaaa " + bodega.toString());
        bodegaFacade.create(bodega);
        
    }
    
}

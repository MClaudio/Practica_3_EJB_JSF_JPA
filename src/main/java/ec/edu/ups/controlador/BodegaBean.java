package ec.edu.ups.controlador;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Localidad;
import java.io.Serializable;
import java.util.List;
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
    
    private String Ciudad;
    private String direccion;
    private String nombre;
    private String pais;
    private String provincia;
    private String telefono;
    private BodegaFacade ejbBodFaced;

    public BodegaBean() {
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
    
      
    public void guardarDatos(){
        Bodega bodega =new Bodega();
        
        bodega.setCiudad(this.Ciudad);
        bodega.setDireccion(this.direccion);
        bodega.setNombre(this.nombre);
        bodega.setPais(this.pais);
        bodega.setProvincia(this.provincia);
        bodega.setTelefono(this.telefono);
        System.out.println("Bodega " + bodega );
        ejbBodFaced.create(bodega);
        
    }
    
}

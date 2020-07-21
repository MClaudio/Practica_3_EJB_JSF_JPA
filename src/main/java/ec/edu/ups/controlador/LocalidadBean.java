/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.LocalidadFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Localidad;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;


/**
 *
 * @author Diego Duchimaza
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "localidadBean")
@SessionScoped
public class LocalidadBean implements Serializable {
      private static final long serialVersionUID = 1;
    
    @EJB
    private LocalidadFacade localidadFacade;
   
      private Bodega bodega; 
     private Usuario usuario;
     private String pais;
    private String provincia;
    private String ciudad;
    private String direccion;
    private String telefono;
    private List<Localidad> localidades;
    private Localidad localidad;
    
       @PostConstruct
    public void init() {
        try {
            this.localidades = localidadFacade.findAll();
            System.out.println("Lista localidades" + this.localidades);

        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
    }
    
    public LocalidadBean(){  
        
    }  

    public LocalidadFacade getLocalidadFacade() {
        return localidadFacade;
    }

    public void setLocalidadFacade(LocalidadFacade localidadFacade) {
        this.localidadFacade = localidadFacade;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidad> localidades) {
        this.localidades = localidades;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
    
  
      public String guardarDatos() {
        Localidad localidad = new Localidad();
        localidad.setPais(this.pais);;
        localidad.setProvincia(this.provincia);
        localidad.setCiudad(this.ciudad);
        localidad.setDireccion(this.direccion);
        localidad.setTelefono(this.telefono);
        localidad.setUsuario(this.usuario);

        System.out.println("Localidad: " + localidad.toString());

        localidadFacade.create(localidad);

        this.localidades= localidadFacade.findAll();
        return null;

    }
      
         public String delete(Localidad localidad) {
        this.localidadFacade.remove(localidad);
          this.localidades = localidadFacade.findAll();
        return null;
    }

    public String edit(Localidad localidad) {
        localidad.setEditable(true);
        return null;
    }

     public String save(Localidad localidad) {
         localidadFacade.edit(localidad);
        localidad.setEditable(false);
        this.localidades = localidadFacade.findAll();
        return null;
    }
        public void listar() {
       
         try {
            this.localidades = localidadFacade.findAll();
            System.out.println("Lista localidades" + this.localidades);

        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
    }
        
}

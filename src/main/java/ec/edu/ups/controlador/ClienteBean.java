/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.LocalidadFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Localidad;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author enriq
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {

    private static final long serialVersionUID = 1;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String ciudad;
    private String direccion;
    private String pais;
    private String provincia;
    private List<Usuario> usuarios;
   
    

    public ClienteBean() {
    }

    @PostConstruct
    public void init() {
        try {
            this.usuarios = usuarioFacade.findAll();
            System.out.println("Lista usuarios"+ this.usuarios);
            
        } catch (Exception e) {
            System.out.println("Error---"+e);
        }
    }  

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public String guardarDatos() {
        Usuario usuario = new Usuario();
        usuario.setNombre(this.nombre);
        usuario.setApellido(this.apellido);
        usuario.setCedula(this.cedula);
        usuario.setCorreo(this.correo);

        Localidad localidad = new Localidad(this.pais, this.provincia, this.ciudad, this.direccion, this.telefono);
        //localidad.setTelefono(this.telefono);
        usuario.addLocalidad(localidad);
        
        System.out.println("Usuario: "+usuario.toString());

        usuarioFacade.create(usuario);
        
        this.usuarios = usuarioFacade.findAll();
        return null;

    }
    
     public String delete(Usuario usuario) {
        this.usuarioFacade.remove(usuario);
        return null;
    }
     
     public String edit(Usuario usuario) {
       usuario.setEditable(true);
        return null;
    }

}

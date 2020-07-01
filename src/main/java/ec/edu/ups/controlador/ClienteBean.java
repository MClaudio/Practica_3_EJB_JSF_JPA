/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;


import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author enriq
 */

@FacesConfig(version=FacesConfig.Version.JSF_2_3)
@Named(value = "clienteBean")
@Dependent
public class ClienteBean implements Serializable{
    
    
    private static final long serialVersionUID=1;
    @EJB
    private UsuarioFacade ejbUsuarioFacade;
    private String nombre;
    private String apellido;
    private int cedula;
    private String telefono;
    private String correo;
    private String ciudad;
    private String direccion;
    private String pais;
    private String password;
    private String provincia;
    private String rol;

   
    
    

   
    public ClienteBean() {
    }

     public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

   public String getRol() {
        return rol;
   }

   public void setRol(String rol) {
      this.rol = rol;
   }

    
    
    
    public UsuarioFacade getEjbUsuarioFacade() {
        return ejbUsuarioFacade;
    }

    public void setEjbUsuarioFacade(UsuarioFacade ejbUsuarioFacade) {
        this.ejbUsuarioFacade = ejbUsuarioFacade;
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
    
    public void guardarDatos(){
        Usuario usuario=new Usuario();
        usuario.setNombre(this.nombre);
        usuario.setApellido(this.apellido);
        //usuario.setCedula(this.cedula);
        //usuario.setTelefono(this.telefono);
        //usuario.setCorreo(this.correo);
        //usuario.setCiudad(this.ciudad);
        //usuario.setDireccion(this.direccion);
        //usuario.setPais(this.pais);
        //usuario.setPassword(this.password);
        //usuario.setProvincia(this.provincia);
        usuario.setRol(this.rol);
        ejbUsuarioFacade.create(usuario);
        
    }
    
    
}

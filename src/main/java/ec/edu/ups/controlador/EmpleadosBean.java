/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author claum
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "empleadosBean")
@RequestScoped
public class EmpleadosBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    private List<Usuario> usuarios;

    /**
     * Creates a new instance of EmpleadosBean
     */
    public EmpleadosBean() {
    }
    
    @PostConstruct
    public void init() {
        try {
            usuarios = usuarioFacade.findEmpleados();
        } catch (Exception e) {
            System.out.println("Error---" + e);
        }
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void eliminar(Usuario usuario){
        usuario.setActivo(false);
        usuarioFacade.edit(usuario);
        usuarios = usuarioFacade.findEmpleados();
    }
    
    public void actiivar(Usuario usuario){
        usuario.setActivo(true);
        usuarioFacade.edit(usuario);
        usuarios = usuarioFacade.findEmpleados();
    }
    
}

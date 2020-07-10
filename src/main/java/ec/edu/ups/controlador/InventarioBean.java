/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.InventarioFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author claum
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "inventarioBean")
@SessionScoped
public class InventarioBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private InventarioFacade inventarioFacade;
    
    private List<Inventario> inventarios;
    private Inventario inventario;
    private Bodega bodega;
    
    /**
     * Creates a new instance of InventarioBean
     */
    public InventarioBean() {
    }

    public List<Inventario> getInventarios() {
        //this.inventarios = inventarioFacade.findAll();
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    public void inventarioProducto(Producto producto){
        System.out.println("Inventario Producto..."+producto.toString());
        this.inventarios = inventarioFacade.findByProducto(producto);
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
      
    public String add() {

       
        return null;

    }

    public String delete(Inventario inventario) {
        
        return null;
    }
    
    public String edit(Inventario inventarioo) {
       
        return null;
    }

    public String save(Inventario inventario) {
       
        return null;
    }
    
}

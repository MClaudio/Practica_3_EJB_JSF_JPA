/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

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
@Named(value = "facturaDetalle")
@SessionScoped
public class FacturaDetalleBean implements Serializable {
    private static final long serialVersionUID = 1;
            
            
    @EJB
    private UsuarioFacade usuarioFacade; 
    
    @EJB
    private FacturaCabeceraFacade facturaCabeceraFacade;
    
    @EJB
    private ProductoFacade productoFacade; 
    
    @EJB
    private FacturaDetalleFacade facturaDetalleFacade;
    
   
    
    private String cedula;
    private int cantidad;
    private List<FacturaCabecera> facturaCabecera;
    private Producto producto;
    
    private List<FacturaDetalle> detalles;
   
    private Usuario usuario;

    public FacturaDetalleBean() {
    }
  
    
    

   
   
    
    @PostConstruct
    public void init(){
        this.facturaCabecera=facturaCabeceraFacade.findAll();
        System.out.println("Lista Factura Cabecera"+facturaCabecera);
        //this.producto=productoFacade.findAll();
        this.detalles=new ArrayList<>();
        
                
        
       
        
        
        
        
    }
    

    public List<FacturaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<FacturaDetalle> detalles) {
        this.detalles = detalles;
    }
    
    
    

    public FacturaCabeceraFacade getFacturaCabeceraFacade() {
        return facturaCabeceraFacade;
    }

    public void setFacturaCabeceraFacade(FacturaCabeceraFacade facturaCabeceraFacade) {
        this.facturaCabeceraFacade = facturaCabeceraFacade;
    }

   
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

  

   
    
    

   
    
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<FacturaCabecera> getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(List<FacturaCabecera> facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   

    
    
    public void buscarUsuario() {
        try {
            this.usuario = usuarioFacade.find(this.cedula);
        } catch (Exception e) {
        }
    }
    
    
   // public void detalles(){
     //   this.facturaDetalleFacade=fc.getFactruraDetalles
    //}
    
    public void detalles(FacturaCabecera factura){
       this.detalles=factura.getFacturaDetalles();
       
        System.out.println("Detalles"+this.detalles);
       




    }
    



}

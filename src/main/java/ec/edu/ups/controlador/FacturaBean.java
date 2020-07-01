/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.InventarioFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author Diego Duchimaza
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "facturaBean")
@SessionScoped
public class FacturaBean implements Serializable {

    private static final long serialVersionUID = 1;

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private ProductoFacade productoFacade;
    @EJB
    private FacturaCabeceraFacade facturaCabeceraFacade;
    @EJB
    private InventarioFacade inventarioFacade;

    private String cedula;
    private String productoNombre;
    private Usuario usuario;
    private List<FacturaDetalle> facturaDetalles;
    private Producto producto;
    private FacturaCabecera facturaCabecera;

    public FacturaBean() {
    }

    @PostConstruct
    public void init() {
        facturaDetalles = new ArrayList<>();
        facturaCabecera = new FacturaCabecera();

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public List<FacturaDetalle> getFacturaDetalles() {
        return facturaDetalles;
    }

    public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
        this.facturaDetalles = facturaDetalles;
    }

    public FacturaCabecera getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public void buscarUsuario() {
        try {
            this.usuario = usuarioFacade.find(this.cedula);
        } catch (Exception e) {
        }
    }

    public void buscarProducto() {
        try {
            this.producto = productoFacade.findForName(this.productoNombre);
        } catch (Exception e) {
        }
    }

    public String addProducto() {
        //System.out.println("Producto: "+this.producto);
        FacturaDetalle fd = new FacturaDetalle();
        fd.setCantidad(1);
        fd.setProducto(this.producto);

        if (this.facturaDetalles.contains(fd)) {
            this.addCantidad(facturaDetalles.get(facturaDetalles.indexOf(fd)));
            //System.out.println("Detalles mass: "+this.facturaDetalles);
        } else {
            this.facturaDetalles.add(fd);
            //System.out.println("Detalles agregado: "+this.facturaDetalles);
        }
        this.facturaCabecera.setFacturaDetalles(this.facturaDetalles);
        return null;
    }

    public void addCantidad(FacturaDetalle fd) {
        fd.setCantidad(fd.getCantidad() + 1);
        this.facturaCabecera.setFacturaDetalles(this.facturaDetalles);
    }

    public void deleteCantidad(FacturaDetalle fd) {
        if (fd.getCantidad() - 1 == 0) {
            this.facturaDetalles.remove(fd);
        } else {
            fd.setCantidad(fd.getCantidad() - 1);
        }
        this.facturaCabecera.setFacturaDetalles(this.facturaDetalles);
    }

    public void deleteProducto(FacturaDetalle fd) {
        if (facturaDetalles.contains(fd)) {
            facturaDetalles.remove(fd);
        }
        this.facturaCabecera.setFacturaDetalles(this.facturaDetalles);
    }

    public String generarFactura() {
        this.facturaCabecera.setUsuario(this.usuario);
        this.facturaCabecera.setFecha(new Date());
        facturaCabeceraFacade.create(this.facturaCabecera);
        
        for (FacturaDetalle fd : this.facturaCabecera.getFacturaDetalles()) {
            for (Inventario inv : fd.getProducto().getInventarios()) {
                inv.setCantidad(inv.getCantidad()-fd.getCantidad());
                inventarioFacade.edit(inv);
            }
        }
        

        return null;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author claum
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CategoriaFacade categoriaFacade;
    @EJB
    private BodegaFacade bodegaFacade;
    @EJB
    private ProductoFacade productoFacade;
    private String nombre;
    private String medida;
    private List<Categoria> categorias;
    private Categoria categoria;
    private double precio;
    private int cantidad;
    private List<Bodega> bodegas;
    private Bodega bodega;
    private List<Producto> productos;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        
    }

    @PostConstruct
    public void init() {

        try {
            this.categorias = this.categoriaFacade.findAll();
            this.cantidad = 1;
            this.productos = this.productoFacade.findAll();
            this.bodegas = this.bodegaFacade.findAll();
            
        } catch (Exception e) {
            System.out.println("Error --- " + e);
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(List<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
    

    public String add() {

        if (this.categoria != null && this.bodega != null) {
            //System.out.println("Categoria: "+this.categoria.getNombre());
            Inventario inventario = new Inventario(this.cantidad);
            inventario.setBodega(this.bodega);

            Producto producto = new Producto();
            producto.setNombre(this.nombre);
            producto.setPrecio(this.precio);
            producto.setImagen("/imagen.gpg");
            producto.setUnidadMedida(this.medida);
            producto.setCategoria(this.categoria);
            producto.addInventario(inventario);

            productoFacade.create(producto);
        }else{
            FacesMessage message = new FacesMessage("Debe seleccionar una categoria y una bodega");
	    throw new ValidatorException(message);
        }
        this.productos= this.productoFacade.findAll();

        return null;
        
    }

    public String delete(Producto producto) {
        this.productoFacade.remove(producto);
        this.productos= this.productoFacade.findAll();
        return null;
    }
    

    public String edit(Producto producto) {
        producto.setEditable(true);
        return null;
    }

    public String save(Producto producto) {
        productoFacade.edit(producto);
        producto.setEditable(false);
         this.productos = this.productoFacade.findAll();
        return null;
    }
  

}

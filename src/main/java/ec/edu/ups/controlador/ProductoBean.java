/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.BodegaFacade;
import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.ejb.InventarioFacade;
import ec.edu.ups.ejb.LocalidadFacade;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Localidad;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;

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
    private UsuarioFacade usuf;
    private LocalidadFacade lf;
    private InventarioFacade inf;
    private CategoriaFacade categoriaFacade;
    private BodegaFacade bodegaFacade;
    private ProductoFacade productoFacade;
    private String nombre;
    private List<Categoria> categorias;
    private Categoria categoria;
    private double precio;
    private int cantidad;
    private List<Bodega> bodegas;
    private Bodega bodega;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
    }

    @PostConstruct
    public void init() {
        /*
        Usuario usu= new Usuario();
        usu.setNombre("clauks");
        usu.setApellido("kjhsad");
        usu.setCedula("010236223");
        usu.setCorreo("claudio@mail.com");
        usuf.create(usu);
         */

        //Categoria cat = new Categoria("Limpieza", "Articulos");
        //categoriaFacade.create(cat);
        //Producto prod = new Producto("jabon", "klg", "/img", 0.90);
        //productoFacade.create(prod);
        //Bodega bodega = new Bodega("Bodega Sur");
        //Localidad loc = new Localidad("Ecuador", "Azuay", "Cuenca", "Av 12");
        //bodega.setLocalidad(loc);
        //bodegaFacade.create(bodega);
        //Inventario inv = new Inventario(5);
        //inf.create(inv);
        //Localidad loc = new Localidad("Ecuador", "Azuay", "Cuenca", "Av 12");
        //lf.create(loc);
        try {
            this.categorias = categoriaFacade.findAll();
            this.cantidad = 1;
            //System.out.println("Bodegas: "+bodegaFacade.findAll());
            //this.bodegas = bodegaFacade.findAll();
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
        //System.out.println("Guardandooo");
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

    public void guardarDatos() {
        /*
        System.out.println("Categoria: "+this.categoria.getNombre());
        Producto producto = new Producto();
        producto.setNombre(this.nombre);
        producto.setPrecio(this.precio);
        producto.setImagen("/imagen.gpg");
        producto.setCategoria(this.categoria);
        producto.addInventario(new Inventario(this.cantidad));
        productoFacade.create(producto);    
        System.out.println("Guardadooo");
         */
        //Bodega bd = new Bodega();
        //bd.setNombre("Bodega sur");

        //bd.setLocalidad(loc);
        //bodegaFacade.create(bd);
        //Categoria cat = new Categoria("Lacteos", "Productos lacteos");
        //categoriaFacade.create(cat);
    }

}

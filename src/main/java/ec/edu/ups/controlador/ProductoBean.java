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
import java.util.ArrayList;
import java.util.Arrays;
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
    private Bodega newBodega;
    private List<Producto> productos;
    private List<String> unidadMedidas;
    private List<Bodega> listbodegas;

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {

    }

    @PostConstruct
    public void init() {
        this.unidadMedidas = new ArrayList<>();
        this.unidadMedidas = Arrays.asList(
                "unitario",
                "lb",
                "kg",
                "l"
        );

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

    public List<String> getUnidadMedidas() {
        return unidadMedidas;
    }

    public List<Bodega> getListbodegas() {
        return listbodegas;
    }

    public void setListbodegas(List<Bodega> listbodegas) {
        this.listbodegas = listbodegas;
    }

    public Bodega getNewBodega() {
        return newBodega;
    }

    public void setNewBodega(Bodega newBodega) {
        this.newBodega = newBodega;
    }
    

    public void newProducto() {
        this.listbodegas = new ArrayList<>();
   }

    public void addBodega() {
       
        if (newBodega != null) {
            System.out.println("Nuevo inventario agregandoo....  "+newBodega.toString());
            if (!listbodegas.contains(this.newBodega)) {
                this.listbodegas.remove(this.newBodega);
            }
        }else{
             System.out.println("bodega nueva null.......");
        }
    }

    public void removeBodega(Bodega bodega) {
        if(listbodegas.contains(bodega)){
            this.listbodegas.remove(bodega);
        }
    }

    public String add() {
        System.out.println("Se crea un productoo...");
        if (this.categoria != null && this.bodega != null) {
            Inventario inventario = new Inventario(this.cantidad);
            inventario.setBodega(this.bodega);

            Producto producto = new Producto();
            producto.setNombre(this.nombre);
            producto.setPrecio(this.precio);
            producto.setImagen("imagen.gpg");
            producto.setUnidadMedida(this.medida);
            producto.setCategoria(this.categoria);
            producto.addInventario(inventario);

            productoFacade.create(producto);
        } else {
            FacesMessage message = new FacesMessage("Debe seleccionar una categoria y una bodega");
            throw new ValidatorException(message);
        }

        this.productos = this.productoFacade.findAll();
        return null;

    }

    public String delete(Producto producto) {
        this.productoFacade.remove(producto);
        this.productos = this.productoFacade.findAll();
        return null;
    }

    public void buscarPorBodega() {
        if (bodega != null) {
            //System.out.println("Cambio de item em bodega..." +bodegaItem.toString());
            this.productos = productoFacade.findForBodega(this.bodega.getCodigo());
        } else {
            //System.out.println("Es nulo... ");
            this.productos = this.productoFacade.findAll();
        }
    }

    public String edit(Producto producto) {
        producto.setEditable(true);
        return null;
    }

    public String save(Producto producto) {
        //System.out.println("Categoria a editar..."+categoria);
        producto.setCategoria(this.categoria);
        productoFacade.edit(producto);
        producto.setEditable(false);
        this.productos = this.productoFacade.findAll();
        return null;
    }

}

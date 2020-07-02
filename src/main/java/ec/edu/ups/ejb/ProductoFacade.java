/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author criss
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Producto> findForName(String name){
        //String jpql = "FROM PRODUCTO p INNER JOIN INVENTARIO i ON i.PRODUCTO_CODIGO = p.CODIGO WHERE p.nombre LIKE '"+name+"%' AND i.CANTIDAD > 0";
        String jpql = "FROM Producto p, Inventario i WHERE p.codigo = i.producto.codigo AND i.cantidad > 0 AND p.nombre LIKE '" +name+ "%'";
        return (List<Producto>) em.createQuery(jpql).getResultList();
    }
    
    public List<Producto> findForBodega(int codigo){
        
        String jpql = "SELECT p FROM Producto p, Inventario i, Bodega b WHERE p.codigo = i.producto.codigo AND b.codigo = i.bodega.codigo AND b.codigo = "+codigo;
        return (List<Producto>) em.createQuery(jpql).getResultList();
        
    }

}

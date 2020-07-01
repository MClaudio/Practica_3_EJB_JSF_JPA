/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author criss
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{
    
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public ProductoFacade() {
        super(Producto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Producto findForName(String name){
        //String jpql = "FROM PRODUCTO p INNER JOIN INVENTARIO i ON i.PRODUCTO_CODIGO = p.CODIGO WHERE p.nombre LIKE '"+name+"%' AND i.CANTIDAD > 0";
        String jpql = "FROM Producto p WHERE p.nombre LIKE '" + name+ "%'";
        return (Producto) em.createQuery(jpql).getSingleResult();
    }
    
}

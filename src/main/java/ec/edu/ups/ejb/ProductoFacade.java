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
    
}

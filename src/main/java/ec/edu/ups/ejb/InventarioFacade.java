/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author claum
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario>{
    
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public InventarioFacade() {
        super(Inventario.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Inventario> findByProducto(Producto producto){
        String jpql = "FROM Inventario i INNER JOIN Producto p ON p.inventario.codigo = i.codigo WHERE p.codigo = "+producto.getCodigo();
        return (List<Inventario>) em.createQuery(jpql).getResultList();
    }
    
}

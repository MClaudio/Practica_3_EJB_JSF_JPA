/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author criss
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public CategoriaFacade() {
        super(Categoria.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Categoria> findByName(String name) {
        System.out.println("llego al metodo de buscar...............................");
        
        System.out.println("nombre....... " + name.toString());
        String jpql = "FROM Categoria c WHERE c.nombre LIKE '" + name + "%'";
        
        System.out.println("Lista================================== " +  em.createQuery(jpql).getResultList());
        return (List<Categoria>) em.createQuery(jpql).getResultList();
    }

}

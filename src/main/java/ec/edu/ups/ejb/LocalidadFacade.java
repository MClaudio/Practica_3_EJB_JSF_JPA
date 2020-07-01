/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;


import ec.edu.ups.modelo.Localidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author claum
 */
@Stateless
public class LocalidadFacade extends AbstractFacade<Localidad>{

    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public LocalidadFacade() {
        super(Localidad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

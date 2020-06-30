/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.FacturaDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enriq
 */
@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> {
    
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public FacturaDetalleFacade() {
        super(FacturaDetalle.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em; 
    }
}

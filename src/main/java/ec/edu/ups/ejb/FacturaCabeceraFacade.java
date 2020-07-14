/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.FacturaCabecera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author enriq
 */
@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera>{
    
    @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public FacturaCabeceraFacade() {
        super(FacturaCabecera.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em; 
    }
    
   
    
    
}

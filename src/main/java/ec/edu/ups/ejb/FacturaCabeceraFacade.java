/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.FacturaCabecera;
import java.util.List;
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
    
    public List<FacturaCabecera> findByStatuPendiente() {
        String jpql = "FROM FacturaCabecera fc WHERE fc.estado = 'pendiente' ORDER BY fc.codigo DESC"; 
        return (List<FacturaCabecera>) em.createQuery(jpql).getResultList();
    }
    
    public List<FacturaCabecera> findByStatuNotPendiente() {
        String jpql = "FROM FacturaCabecera fc WHERE fc.estado <> 'pendiente' ORDER BY fc.codigo DESC";
        return (List<FacturaCabecera>) em.createQuery(jpql).getResultList();
    }
 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.ejb;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego Duchimaza
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{
    
     @PersistenceContext(unitName = "persistencia")
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       return em; 
    }
    
    public int contarFacturas(Usuario u){
        
        
        String jpql = "SELECT COUNT(u.cedula) FROM Usuario u INNER JOIN FacturaCabecera f ON u.cedula = f.usuario.cedula WHERE u.cedula ='"+u.getCedula()+"' ";
        
        //System.out.println("Dato de base... " + em.createQuery(jpql).getSingleResult());
        Object obj = em.createQuery(jpql).getSingleResult();
        if(obj != null){
            return Integer.valueOf(String.valueOf(obj));
        }else{
            return 0;
        }
    
        
        
    }
    
  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.ejb.FacturaCabeceraFacade;
import ec.edu.ups.ejb.FacturaDetalleFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Usuario;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Diego Duchimaza
 */
@Named(value = "facturaBean")
@Dependent
public class FacturaBean {
       private static final long serialVersionUID = 1;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private FacturaDetalleFacade facturaDetalleFacade;
    @EJB
    private FacturaCabeceraFacade facturaCabeceraFacade;

    private FacturaCabecera facturaCabecera;
    private Usuario usuario;

    
    
}

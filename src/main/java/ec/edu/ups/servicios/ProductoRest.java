/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author claum
 */
@Path("/productos")
public class ProductoRest {
    
    @GET @Produces(MediaType.TEXT_PLAIN)
    public String getProductos(){
        return "Hola Mundo desde el path Productos";
    }
}

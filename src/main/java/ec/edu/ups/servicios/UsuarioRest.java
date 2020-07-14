/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Usuario;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author claum
 */
@Path("/usuario")
public class UsuarioRest {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Jsonb jsonb;

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuario() {
        return "Hola Mundo desde el path Productos";
    }
*/
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response createUsuario(String jsonUsuario) {
        jsonb = JsonbBuilder.create();
        Usuario newUsuaio = jsonb.fromJson(jsonUsuario, Usuario.class);
        try {
            usuarioFacade.create(newUsuaio);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(500).entity("Usuario no creado: " + e).build();
        }
    }
    
    @PUT
    @Path("/{usuarioID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editDireccion(@PathParam("usuarioID") String usuarioID, String jsonLocalidad) {
        //System.out.println("usuario cedula "+id);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);
            if (usuario != null) {
                try {
                    usuarioFacade.edit(jsonb.fromJson(jsonLocalidad, Usuario.class));
                    return Response.ok().entity("Usuario actualizado").build();
                } catch (Exception e) {
                    return Response.status(500).entity("Error al actualizar: " + e).build();
                }
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
            
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos insuficientes").build();
        }
    }
    
    @DELETE
    @Path("/{usuarioID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDireccion(@PathParam("usuarioID") String usuarioID) {
        //System.out.println("usuario cedula "+id);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);

            if (usuario != null) {
                try { 
                    usuarioFacade.remove(usuario);
                    return Response.ok().entity("Usuario eliminado").build();
                    
                } catch (Exception e) {
                    return Response.status(500).entity("Error al eliminar: " + e).build();
                }
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
            
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos insuficientes").build();
        }
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUsuario(@FormParam("correo") String correo, @FormParam("password") String password) {
        
        if (correo != null && password != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.finByEmailAndPass(correo, password);
            
            System.out.println("Usuario en en rest "+usuario.getFacturas());
            //System.out.println("Json Usuario "+jsonb.toJson(usuario));

            if (usuario != null) {
                return Response.ok(jsonb.toJson(usuario)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos insuficientes").build();
        }
    }

        
    
}

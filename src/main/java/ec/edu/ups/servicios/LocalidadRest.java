/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import ec.edu.ups.ejb.LocalidadFacade;
import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.Localidad;
import ec.edu.ups.modelo.Usuario;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/localidad")
public class LocalidadRest {
    @EJB
    private LocalidadFacade localidadFacade;
    @EJB
    private UsuarioFacade usuarioFacade;
    private Jsonb jsonb;
    
    @GET
    @Path("/{usuarioID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDirecciones(@PathParam("usuarioID") String usuarioID) {
        System.out.println("usuario cedula "+usuarioID);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);
            if (usuario != null) {
                return Response.ok(jsonb.toJson(usuario.getLocalidades())).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos insuficientes").build();
        }
    }
      
    @POST
    @Path("/{usuarioID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addDireccion(@PathParam("usuarioID") String usuarioID, String jsonLocalidad) {
        //System.out.println("usuario cedula "+id);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);

            if (usuario != null) {
                try {
                    Localidad newLocalidad = jsonb.fromJson(jsonLocalidad, Localidad.class);
                    newLocalidad.setUsuario(usuario);
                    
                    localidadFacade.create(newLocalidad);
                    return Response.ok().entity("Localidad creada").build();
                } catch (Exception e) {
                    return Response.status(500).entity("Localidad no creada: " + e).build();
                }
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Usuario no encontrado").build();
            }
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos insuficientes").build();
        }
    }
    
    @PUT
    @Path("/{usuarioID}/{direccionID}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response editDireccion(@PathParam("usuarioID") String usuarioID, @PathParam("direccionID") int direccionID, String jsonLocalidad) {
        //System.out.println("usuario cedula "+id);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);

            if (usuario != null) {
                try {
                    localidadFacade.edit(jsonb.fromJson(jsonLocalidad, Localidad.class));
                    return Response.ok().entity("Localidad actualizada").build();
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
    @Path("/{usuarioID}/{direccionID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDireccion(@PathParam("usuarioID") String usuarioID, @PathParam("direccionID") int direccionID) {
        //System.out.println("usuario cedula "+id);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);

            if (usuario != null) {
                try {
                    Localidad localidad = localidadFacade.find(direccionID);
                    localidadFacade.remove(localidad);
                    return Response.ok().entity("Localidad eliminada").build();
                    
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
}

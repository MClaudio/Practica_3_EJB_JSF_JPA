/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import ec.edu.ups.ejb.UsuarioFacade;
import ec.edu.ups.modelo.FacturaCabecera;
import ec.edu.ups.modelo.FacturaDetalle;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Localidad;
import ec.edu.ups.modelo.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.primefaces.json.JSONObject;

/**
 *
 * @author claum
 */
@Path("/factura")
public class FacturasRest {

    @EJB
    private UsuarioFacade usuarioFacade;
    private Jsonb jsonb;

    @GET
    @Path("/{usuarioID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getfacturas(@PathParam("usuarioID") String usuarioID) {
        System.out.println("usuario cedula " + usuarioID);
        if (usuarioID != null) {
            jsonb = JsonbBuilder.create();
            Usuario usuario = usuarioFacade.find(usuarioID);
            if (usuario != null) {
                return Response.ok(jsonb.toJson(usuario.getFacturas())).build();
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
    public Response addDireccion(@PathParam("usuarioID") String usuarioID, String jsonFactura) {
        
        if (usuarioID != null) {
            Usuario usuario = usuarioFacade.find(usuarioID);
            
            /*
            User user = new User();
            user.setuserID(obj.getString("userID"));
            user.setisMale(obj.getBoolean("isMale"));
            user.setEmail(obj.getString("email"));
            // user.setBirthdate(obj.getDate("birthdate"));
            user.setLastName(obj.getString("lastName"));
            user.setFirstName(obj.getString("firstName"));
*/
            if (usuario != null) {
                try {
                    FacturaCabecera fc = new FacturaCabecera();
                    fc.setFecha(LocalDate.now());
 
                    JSONObject obj = new JSONObject(jsonFactura);
                    System.out.println("Json en facturas "+obj.get("detalles"));
                    
                    //jsonb.fromJson((String) obj.get("detalles"), Localidad.class);
                    
                    
                    //jsonb = JsonbBuilder.create();
                    //List<FacturaDetalle> detalles = jsonb.fromJson(obj.detalle, Localidad.class);
                    
                    /*
                    //System.out.println("Locaidad en guardar factura.." + this.localidad);
                    if (usuario != null && localidad != null && facturaDetalles.size() > 0) {

                        this.facturaCabecera.setUsuario(this.usuario);
                        this.facturaCabecera.setLocalidad(this.localidad);
                        this.facturaCabecera.setFecha(LocalDate.now());
                        this.facturaCabecera.calcularSubTotal();
                        this.facturaCabecera.calcularTotal();
                        try {
                            for (FacturaDetalle fd : this.facturaCabecera.getFacturaDetalles()) {
                                fd.setFacturaCabecera(facturaCabecera);
                                for (Inventario inv : fd.getProducto().getInventarios()) {
                                    inv.setCantidad(inv.getCantidad() - fd.getCantidad());
                                    inventarioFacade.edit(inv);
                                }
                                facturaCabeceraFacade.create(this.facturaCabecera);
                            }
                        } catch (Exception e) {
                        }

                        facturaCabecera = new FacturaCabecera();
                        usuario = null;
                        localidad = null;
                        facturaDetalles = new ArrayList<>();
                    }
                     */
                    //Localidad newLocalidad = jsonb.fromJson(jsonLocalidad, Localidad.class);
                    //newLocalidad.setUsuario(usuario);

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
}

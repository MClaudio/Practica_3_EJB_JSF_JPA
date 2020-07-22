/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.servicios;

import ec.edu.ups.ejb.CategoriaFacade;
import ec.edu.ups.modelo.Categoria;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.sound.sampled.Port;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author criss
 */
@Path("/categorias")
public class CategoriaRes {

    @EJB
    private CategoriaFacade categoriaFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        System.out.println("hola...................................");
        Jsonb jsonb = JsonbBuilder.create();

        List<Categoria> categoria = categoriaFacade.findAll();
        System.out.println("Categorias................ " + categoria);
        return Response.ok(jsonb.toJson(categoria)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
        if (id != null) {
            System.out.println("Id..................................." + id);
            Jsonb jsonb = JsonbBuilder.create();

            Categoria categoria = categoriaFacade.find(id);
            categoria.getProductos();
            System.out.println("Categorias................ " + categoria.getProductos().toString());

            if (categoria != null) {
                return Response.ok(jsonb.toJson(categoria)).header("Access-Control-Allow-Origin", "*").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Categorias no encontradas").build();

            }

        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Datos Insuvicientes").build();

        }

    }

}

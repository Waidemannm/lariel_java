package br.com.fiap.resource;

import br.com.fiap.bo.RecadosPendetesBO;
import br.com.fiap.to.RecadosPendentesTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pendentes")
public class RecadosPendentesResource {

    private RecadosPendetesBO recadosPendetesBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<RecadosPendentesTO> resultado = recadosPendetesBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        }
        else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid RecadosPendentesTO recadosPendentesTO){
        RecadosPendentesTO resultado = recadosPendetesBO.save(recadosPendentesTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 401 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{idRecadoPendente}")
    public Response delete(@PathParam("idRecadoPendente") Long idRecadoPendente){
        Response.ResponseBuilder response = null;
        if (recadosPendetesBO.delete(idRecadoPendente)){
            response = Response.status(204);  // 204 - NO CONTENT
        } else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        return response.build();
    }
}

package br.com.fiap.resource;

import br.com.fiap.bo.ConviteBO;
import br.com.fiap.to.ConviteTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/convites")
public class ConviteResource {
    private ConviteBO conviteBO = new ConviteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<ConviteTO> resultado = conviteBO.findAll();
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
    public Response save(@Valid ConviteTO conviteTO){
        ConviteTO resultado = conviteBO.save(conviteTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 401 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{nomeConvite}/{idConvite}")
    public Response findConvite(@PathParam("nomeConvite")String nomeConvite, @PathParam("idConvite") String idConvite){
        ConviteTO resultado = conviteBO.findConvite(nomeConvite, idConvite);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();  // 200 (OK)
        } else {
            response = Response.status(404);  // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{idConvite}")
    public Response delete(@PathParam("idConvite")String idConvite){
        Response.ResponseBuilder response = null;
        if (conviteBO.delete(idConvite)){
            response = Response.status(204);  // 204 - NO CONTENT
        } else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{idConvite}")
    public Response update(@Valid ConviteTO conviteTO,@PathParam("idConvite") String idConvite){
        conviteTO.setIdConvite(idConvite);
        ConviteTO resultado = conviteBO.update(conviteTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{nomeConvite}")
    public Response findConviteADM(@PathParam("nomeConvite")String nomeConvite){
        ConviteTO resultado = conviteBO.findConviteADM(nomeConvite);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();  // 200 (OK)
        } else {
            response = Response.status(404);  // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }
}

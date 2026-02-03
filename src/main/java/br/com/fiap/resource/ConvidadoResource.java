package br.com.fiap.resource;

import br.com.fiap.bo.ConvidadoBO;
import br.com.fiap.to.ConvidadoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/convidados")
public class ConvidadoResource {
    private ConvidadoBO convidadoBO = new ConvidadoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findALl(){
        ArrayList<ConvidadoTO> resultado = convidadoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null ){
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ConvidadoTO convidadoTO){
        ConvidadoTO resultado = convidadoBO.save(convidadoTO);
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
    @Path("/{nomeConvidado}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("nomeConvidado") String nomeConvidado){
        ConvidadoTO resultado = convidadoBO.findByName(nomeConvidado);
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
    @Path("/{idConvidado}")
    public Response delete(@PathParam("idConvidado") Long idConvidado){
        Response.ResponseBuilder response = null;
        if (convidadoBO.delete(idConvidado)){
            response = Response.status(204);  // 204 - NO CONTENT
        } else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{idConvidado}")
    public Response update(@Valid ConvidadoTO convidadoTO, @PathParam("idConvidado") Long idConvidado){
        convidadoTO.setIdConvidado(idConvidado);
        ConvidadoTO resultado = convidadoBO.update(convidadoTO);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);  // 201 - CREATED
        } else {
            response = Response.status(400);  // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @Path("/{idConvidado}")
    public Response updateStatus(@Valid ConvidadoTO convidadoTO, @PathParam("idConvidado") Long idConvidado){
        convidadoTO.setIdConvidado(idConvidado);
        ConvidadoTO resultado = convidadoBO.updateStatus(convidadoTO);
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
    @Path("/{idConvite}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByIdConvite(String idConvite){
        ArrayList<ConvidadoTO> resultado = convidadoBO.findByIdConvite(idConvite);
        Response.ResponseBuilder response = null;
        if (resultado != null ){
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}

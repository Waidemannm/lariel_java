package br.com.fiap.resource;

import br.com.fiap.bo.RecadosAceitosBO;
import br.com.fiap.to.RecadosAceitosTO;
import io.vertx.ext.web.FileUpload;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestForm;

import java.util.ArrayList;

@Path("/aceitos")
public class RecadosAceitosResource {

    private RecadosAceitosBO recadosAceitosBO = new RecadosAceitosBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<RecadosAceitosTO> resultado = recadosAceitosBO.findAll();
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
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response save(@Valid RecadosAceitosTO recadosAceitosTO, @RestForm String nomeConvidados,
                         @RestForm String mensagem,
                         @RestForm FileUpload imagem){
        RecadosAceitosTO resultado = recadosAceitosBO.save(recadosAceitosTO);
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
    @Path("/{idRecadoAceito}")
    public Response delete(@PathParam("idRecadoAceito") Long idRecadoAceito){
        Response.ResponseBuilder response = null;
        if (recadosAceitosBO.delete(idRecadoAceito)){
            response = Response.status(204);  // 204 - NO CONTENT
        } else {
            response = Response.status(404);  // 404 - NOT FOUND
        }
        return response.build();
    }
}

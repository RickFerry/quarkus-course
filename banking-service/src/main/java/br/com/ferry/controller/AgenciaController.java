package br.com.ferry.controller;

import br.com.ferry.domain.Agencia;
import br.com.ferry.service.AgenciaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@Path("/agencias")
@RequiredArgsConstructor
public class AgenciaController {
    private final AgenciaService agenciaService;

    @GET
    public RestResponse<List<Agencia>> findAll() {
        return RestResponse.ok(agenciaService.findAll());
    }

    @GET
    @Path("/{id}")
    public RestResponse<Agencia> findById(Long id) {
        return RestResponse.ok(agenciaService.findById(id));
    }

    @POST
    public RestResponse<Void> create(Agencia agencia, @Context UriInfo uriInfo) {
        agenciaService.create(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }

    @PUT
    public RestResponse<Void> atualizar(Agencia agencia) {
        agenciaService.atualizar(agencia);
        return RestResponse.ok();
    }

    @DELETE
    @Path("/{id}")
    public RestResponse<Void> deletar(Long id) {
        agenciaService.deletar(id);
        return RestResponse.ok();
    }
}

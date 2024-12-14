package br.com.ferry.controller;

import br.com.ferry.domain.Agencia;
import br.com.ferry.service.AgenciaService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/agencias")
@RequiredArgsConstructor
public class AgenciaController {
    private final AgenciaService agenciaService;

    @POST
    public RestResponse<Void> cadastrar(Agencia agencia, @Context UriInfo uriInfo) {
        agenciaService.cadastrar(agencia);
        return RestResponse.created(uriInfo.getAbsolutePath());
    }
}

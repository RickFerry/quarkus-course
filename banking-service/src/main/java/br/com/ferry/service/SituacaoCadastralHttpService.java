package br.com.ferry.service;

import br.com.ferry.domain.http.AgenciaHttp;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.Optional;

@Path("/situacao-cadastral")
@RegisterRestClient(configKey = "situacao-cadastral-api")
interface SituacaoCadastralHttpService {

    @GET
    @Path("/{cnpj}")
    Optional<AgenciaHttp> findByCnpj(String cnpj);
}

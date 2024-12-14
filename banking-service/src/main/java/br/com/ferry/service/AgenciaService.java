package br.com.ferry.service;

import br.com.ferry.domain.Agencia;
import br.com.ferry.exception.AgenciaNaoEncontradaException;
import br.com.ferry.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@RequiredArgsConstructor
public class AgenciaService {
    private final AgenciaRepository agenciaRepository;

    @RestClient
    private final SituacaoCadastralHttpService situacaoCadastralHttpService;

    @Transactional
    public void cadastrar(Agencia agencia) {
        situacaoCadastralHttpService.findByCnpj(agencia.getCnpj()).orElseThrow(AgenciaNaoEncontradaException::new);
        agenciaRepository.persist(agencia);
    }
}

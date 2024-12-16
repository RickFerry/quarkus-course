package br.com.ferry.service;

import br.com.ferry.domain.Agencia;
import br.com.ferry.domain.http.SituacaoCadastral;
import br.com.ferry.exception.AgenciaNaoEncontradaOuNaoAtivaException;
import br.com.ferry.repository.AgenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class AgenciaService {
    private final AgenciaRepository agenciaRepository;

    @RestClient
    private SituacaoCadastralHttpService situacaoCadastralHttpService;

    public AgenciaService(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public List<Agencia> findAll() {
        return agenciaRepository.listAll();
    }

    public Agencia findById(Long id) {
        return agenciaRepository.findByIdOptional(id)
                .orElseThrow(AgenciaNaoEncontradaOuNaoAtivaException::new);
    }

    @Transactional
    public void create(Agencia agencia) {
        situacaoCadastralHttpService.findByCnpj(agencia.getCnpj())
                .filter(ag -> ag.getSituacaoCadastral().equals(SituacaoCadastral.ATIVO))
                .orElseThrow(AgenciaNaoEncontradaOuNaoAtivaException::new);
        agenciaRepository.persist(agencia);
    }

    @Transactional
    public void atualizar(Agencia agencia) {
        agenciaRepository.update(
                "nome = ?1, razaoSocial = ?2, cnpj = ?3 where id = ?4",
                agencia.getNome(),
                agencia.getRazaoSocial(),
                agencia.getCnpj(),
                agencia.getId()
        );
    }

    @Transactional
    public void deletar(Long id) {
        agenciaRepository.findByIdOptional(id)
                .ifPresentOrElse(agenciaRepository::delete, () -> {
                    throw new AgenciaNaoEncontradaOuNaoAtivaException();
                });
    }
}

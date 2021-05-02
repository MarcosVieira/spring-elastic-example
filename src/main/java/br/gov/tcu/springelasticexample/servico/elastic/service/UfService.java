package br.gov.tcu.springelasticexample.servico.elastic.service;

import br.gov.tcu.springelasticexample.servico.elastic.dto.TipoPessoas;
import br.gov.tcu.springelasticexample.servico.elastic.dto.Uf;
import br.gov.tcu.springelasticexample.servico.elastic.repository.UfElasticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class UfService {

    @Autowired
    private UfElasticRepository ufElasticRepository;

    public void createUf() {
        createUf(geraUfTeste());
    }

    public void createUf(final Uf uf) {
        ufElasticRepository.save(uf);
    }

    public void createUfs(final List<Uf> ufs) {
        ufElasticRepository.saveAll(ufs);
    }

    private Uf geraUfTeste() {
        Uf uf = new Uf();
        uf.setId(22L);
        uf.setTipo(TipoPessoas.UF.getDescricao());
        uf.setConfiavel(true);
        uf.setNome("Uf Teste Spring");
        uf.setNomesAlternativos(Arrays.asList("UfTeste", "Uf Spring Elasticsearch"));
        uf.setCodIbge(22222L);
        uf.setSiglaUf("UF");
        uf.setCapital("CapitalUf");
        uf.setRegiao("RegiãoUf");
        return uf;
    }

}

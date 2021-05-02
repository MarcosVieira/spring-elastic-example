package br.gov.tcu.springelasticexample.servico.elastic.service;

import br.gov.tcu.springelasticexample.servico.elastic.dto.Pais;
import br.gov.tcu.springelasticexample.servico.elastic.dto.TipoPessoas;
import br.gov.tcu.springelasticexample.servico.elastic.repository.PaisElasticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PaisService {

    @Autowired
    private PaisElasticRepository paisElasticRepository;

    public void createPais() {
        createPais(geraPaisTeste());
    }

    public void createPais(final Pais pais) {
        paisElasticRepository.save(pais);
    }

    public void createPaises(final List<Pais> paises) {
        paisElasticRepository.saveAll(paises);
    }

    private Pais geraPaisTeste() {
        Pais pais = new Pais();
        pais.setId(11L);
        pais.setTipo(TipoPessoas.PAIS.getDescricao());
        pais.setConfiavel(true);
        pais.setNome("Pais Teste Spring");
        pais.setNomesAlternativos(Arrays.asList("PaisTeste", "Pais Spring Elasticsearch"));
        pais.setCodAlfaDois("PT");
        pais.setCodAlfaTres("PTS");
        pais.setCodIsoNumerico(1111);
        pais.setDescrNacionalidade("paistestespringiano");
        pais.setNumDdi(55);
        pais.setNumRfb(1155);
        return pais;
    }

}

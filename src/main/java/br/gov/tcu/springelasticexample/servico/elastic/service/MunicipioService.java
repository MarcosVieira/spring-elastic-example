package br.gov.tcu.springelasticexample.servico.elastic.service;

import br.gov.tcu.springelasticexample.servico.elastic.dto.Municipio;
import br.gov.tcu.springelasticexample.servico.elastic.dto.TipoPessoas;
import br.gov.tcu.springelasticexample.servico.elastic.repository.MunicipioElasticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class MunicipioService {

    @Autowired
    private MunicipioElasticRepository municipioElasticRepository;

    public void createMunicipio() {
        createMunicipio(geraMunicipioTeste());
    }

    public void createMunicipio(final Municipio municipio) {
        municipioElasticRepository.save(municipio);
    }

    public void createMunicipios(final List<Municipio> municipio) {
        municipioElasticRepository.saveAll(municipio);
    }

    private Municipio geraMunicipioTeste() {
        Municipio municipio = new Municipio();
        municipio.setId(33L);
        municipio.setTipo(TipoPessoas.UF.getDescricao());
        municipio.setConfiavel(true);
        municipio.setNome("Uf Teste Spring");
        municipio.setNomesAlternativos(Arrays.asList("MunicpioTeste", "Municipio Spring Elasticsearch"));
        municipio.setCodIbge(33333L);
        municipio.setSiglaUf("UF");
        return municipio;
    }

}

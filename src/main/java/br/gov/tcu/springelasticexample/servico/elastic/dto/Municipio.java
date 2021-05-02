package br.gov.tcu.springelasticexample.servico.elastic.dto;

import br.gov.tcu.springelasticexample.servico.dto.DtoMunicipio;
import br.gov.tcu.springelasticexample.servico.dto.DtoTipoPessoa;
import br.gov.tcu.springelasticexample.servico.dto.DtoUnidadeFederativa;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Representa os dados próprios do conceito de Município dentro do ElasticSearch.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(indexName="#{@indiceMunicipios}")
public class Municipio extends Pessoas {
    private static final String MSG_PESSOA_NAO_PODE_SER_MUNICIPIO = "Pessoa recuperada do ElasticSearch não é do tipo Município: %s";

    @Field(type = FieldType.Long)
    private Long codIbge;
    @Field(type = FieldType.Keyword)
    private String siglaUf;

    public DtoMunicipio toDtoMunicipio() {
        if (!TipoPessoas.MUNICIPIO.getDescricao().equalsIgnoreCase(getTipo())) {
            throw new IllegalStateException(String.format(MSG_PESSOA_NAO_PODE_SER_MUNICIPIO, toString()));
        }

        DtoUnidadeFederativa dtoUnidadeFederativa = new DtoUnidadeFederativa();
        dtoUnidadeFederativa.setSigla(getSiglaUf());

        DtoMunicipio dtoMunicipio = new DtoMunicipio();
        dtoMunicipio.setId(getId());
        dtoMunicipio.setDtoTipoPessoa(new DtoTipoPessoa(DtoTipoPessoa.ENTE_FEDERACAO));
        dtoMunicipio.setConfiavel(getConfiavel());
        dtoMunicipio.setNome(getNome());
        dtoMunicipio.setNomesAlternativos(getNomesAlternativos());
        dtoMunicipio.setCodNoIbge(getCodIbge());
        dtoMunicipio.setDtoUnidadeFederativa(dtoUnidadeFederativa);
        return dtoMunicipio;
    }

}

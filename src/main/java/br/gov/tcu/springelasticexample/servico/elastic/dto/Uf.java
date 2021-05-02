package br.gov.tcu.springelasticexample.servico.elastic.dto;

import br.gov.tcu.springelasticexample.servico.dto.DtoTipoPessoa;
import br.gov.tcu.springelasticexample.servico.dto.DtoUnidadeFederativa;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Representa os dados próprios do conceito de Uf dentro do ElasticSearch.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(indexName="#{@indiceUfs}")
public class Uf extends Pessoas {
    private static final String MSG_PESSOA_NAO_PODE_SER_UF = "Pessoa recuperada do ElasticSearch não é do tipo Uf: %s";

    @Field(type = FieldType.Long)
    private Long codIbge;
    @Field(type = FieldType.Keyword)
    private String siglaUf;
    @Field(type = FieldType.Keyword)
    private String capital;
    @Field(type = FieldType.Keyword)
    private String regiao;

    public DtoUnidadeFederativa toDtoUnidadeFederativa() {
        if (!TipoPessoas.UF.getDescricao().equalsIgnoreCase(getTipo())) {
            throw new IllegalStateException(String.format(MSG_PESSOA_NAO_PODE_SER_UF, toString()));
        }

        DtoUnidadeFederativa dtoUnidadeFederativa = new DtoUnidadeFederativa();
        dtoUnidadeFederativa.setId(getId());
        dtoUnidadeFederativa.setDtoTipoPessoa(new DtoTipoPessoa(DtoTipoPessoa.ENTE_FEDERACAO));
        dtoUnidadeFederativa.setConfiavel(getConfiavel());
        dtoUnidadeFederativa.setNome(getNome());
        dtoUnidadeFederativa.setNomesAlternativos(getNomesAlternativos());
        dtoUnidadeFederativa.setCodNoIbge(getCodIbge());
        dtoUnidadeFederativa.setSigla(getSiglaUf());
        dtoUnidadeFederativa.setRegiao(getRegiao());
        dtoUnidadeFederativa.setNomeCapital(getCapital());
        return dtoUnidadeFederativa;
    }

}

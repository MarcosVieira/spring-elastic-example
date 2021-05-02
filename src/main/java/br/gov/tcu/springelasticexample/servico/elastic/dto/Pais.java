package br.gov.tcu.springelasticexample.servico.elastic.dto;

import br.gov.tcu.springelasticexample.servico.dto.DtoPais;
import br.gov.tcu.springelasticexample.servico.dto.DtoTipoPessoa;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Representa os dados próprios do conceito de País dentro do ElasticSearch.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Document(indexName="#{@indicePaises}")
public class Pais extends Pessoas {
    private static final String MSG_PESSOA_NAO_PODE_SER_PAIS = "Pessoa recuperada do ElasticSearch não é do tipo País: %s";

    @Field(type = FieldType.Keyword)
    private String codAlfaDois;
    @Field(type = FieldType.Keyword)
    private String codAlfaTres;
    @Field(type = FieldType.Integer)
    private Integer codIsoNumerico;
    @Field(type = FieldType.Keyword)
    private String descrNacionalidade;
    @Field(type = FieldType.Integer)
    private Integer numRfb;
    @Field(type = FieldType.Integer)
    private Integer numDdi;

    public DtoPais toDtoPais() {
        if (!TipoPessoas.PAIS.getDescricao().equalsIgnoreCase(getTipo())) {
            throw new IllegalStateException(String.format(MSG_PESSOA_NAO_PODE_SER_PAIS, toString()));
        }

        DtoPais dtoPais = new DtoPais();
        dtoPais.setId(getId());
        dtoPais.setDtoTipoPessoa(new DtoTipoPessoa(DtoTipoPessoa.PAIS));
        dtoPais.setConfiavel(getConfiavel());
        dtoPais.setNome(getNome());
        dtoPais.setNomesAlternativos(getNomesAlternativos());
        dtoPais.setCodAlfaDois(getCodAlfaDois());
        dtoPais.setCodAlfaTres(getCodAlfaTres());
        dtoPais.setCodIsoNumerico(getCodIsoNumerico());
        dtoPais.setDescrNacionalidade(getDescrNacionalidade());
        dtoPais.setNumRfb(getNumRfb());
        dtoPais.setNumDdi(getNumDdi());
        return dtoPais;
    }

}

package br.gov.tcu.springelasticexample.servico.elastic.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Representa os atributos básicos comuns a todas as Pessoas dentro do ElasticSearch.
 * 
 */
@Getter
@Setter
public abstract class Pessoas {
    @Id
    @Field(type = FieldType.Long)
    private Long id;
    @Field(type = FieldType.Keyword)
    private String tipo;
    @Field(type = FieldType.Boolean)
    private Boolean confiavel;
    @Field(type = FieldType.Text)
    private String nome;
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<String> nomesAlternativos;
}

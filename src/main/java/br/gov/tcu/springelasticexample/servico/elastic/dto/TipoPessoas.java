package br.gov.tcu.springelasticexample.servico.elastic.dto;

import lombok.Getter;

@Getter
public enum TipoPessoas {
    PAIS("PAIS"),
    UF("UF"),
    MUNICIPIO("MUNICIPIO");

    private String descricao;

    TipoPessoas(final String descricao) {
        this.descricao = descricao;
    }
}

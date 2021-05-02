package br.gov.tcu.springelasticexample.servico.rest.elastic;

import lombok.Getter;

@Getter
public enum TipoErroAcessoApi {
    ERRO("erro"),
    INFO("info"),
    ALERTA("alerta");

    private String descricao;

    TipoErroAcessoApi(final String descricao) {
        this.descricao = descricao;
    }
}

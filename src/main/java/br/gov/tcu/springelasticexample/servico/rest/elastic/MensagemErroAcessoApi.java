package br.gov.tcu.springelasticexample.servico.rest.elastic;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MensagemErroAcessoApi {
    private TipoErroAcessoApi tipo;
    private String mensagem;
    private String codigoParaUsoCliente;
    private String parametrosParaUsoCliente;
}
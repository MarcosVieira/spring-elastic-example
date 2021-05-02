package br.gov.tcu.springelasticexample.servico.rest.elastic;

import com.google.gson.Gson;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MensagensErroAcessoApi {
    @Builder.Default
    private List<MensagemErroAcessoApi> mensagens = new ArrayList<>();

    public MensagensErroAcessoApi incluiMensagem(final MensagemErroAcessoApi mensagemErroAcessoApi) {
        mensagens.add(mensagemErroAcessoApi);
        return this;
    }

    public MensagensErroAcessoApi incluiMensagens(final List<MensagemErroAcessoApi> mensagensErroAcessoSiafi) {
        if (!CollectionUtils.isEmpty(mensagensErroAcessoSiafi)) {
            mensagens.addAll(mensagensErroAcessoSiafi);
        }
        return this;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
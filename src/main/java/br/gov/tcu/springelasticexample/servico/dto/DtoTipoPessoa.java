package br.gov.tcu.springelasticexample.servico.dto;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa uma pessoa, no nível abstrato. A raiz da estrutura de pessoas.
 */
public class DtoTipoPessoa implements Serializable, Comparable<DtoTipoPessoa> {
    /*
     * CUIDADO: essas constantes devem ser IGUAIS às definidas no TipoPessoa
     */
    public static final Long PESSOA_FISICA = Long.parseLong("1");
    public static final Long PESSOA_JURIDICA = Long.parseLong("2");
    public static final Long ENTE_FEDERACAO = Long.parseLong("3");
    public static final Long ORGAO_ADM_DIRETA = Long.parseLong("4");
    public static final Long PAIS = Long.parseLong("5");
    public static final Long FUNDO = Long.parseLong("6");
    public static final Long PESSOA_JURIDICA_PENDENTE = Long.parseLong("7");
    private static final long serialVersionUID = 1L;
    private Long cod;
    private LocalDateTime dataHoraExclusao;

    public DtoTipoPessoa(Long cod) {
        this.cod = cod;
    }

    public DtoTipoPessoa() {
        /*
         * Construtor vazio para inicialização de elementos da camada web.
         */
    }

    public static DtoTipoPessoa criarDtoTipoPessoaFisica() {
        return criarDtoTipoPessoa(PESSOA_FISICA);
    }

    public static DtoTipoPessoa criarDtoTipoPessoaJuridica() {
        return criarDtoTipoPessoa(PESSOA_JURIDICA);
    }

    public static DtoTipoPessoa criarDtoTipoPessoaEnteFederacao() {
        return criarDtoTipoPessoa(ENTE_FEDERACAO);
    }

    public static DtoTipoPessoa criarDtoTipoPessoaOrgaoAdmDireta() {
        return criarDtoTipoPessoa(ORGAO_ADM_DIRETA);
    }

    public static DtoTipoPessoa criarDtoTipoPessoaPais() {
        return criarDtoTipoPessoa(PAIS);
    }

    public static DtoTipoPessoa criarDtoTipoFundo() {
        return criarDtoTipoPessoa(FUNDO);
    }

    public static DtoTipoPessoa criarDtoTipoPessoaJuridicaPendente() {
        return criarDtoTipoPessoa(PESSOA_JURIDICA_PENDENTE);
    }

    private static DtoTipoPessoa criarDtoTipoPessoa(Long cod) {
        return new DtoTipoPessoa(cod);
    }

    public Long getCod() {
        return this.cod;
    }

    public void setCod(final Long cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        String descricao = "Não Definido";

        if (cod == null) {
            descricao = null;
        } else if (cod.equals(PESSOA_FISICA)) {
            descricao = "Pessoa Física";
        } else if (cod.equals(PESSOA_JURIDICA)) {
            descricao = "Entidade";
        } else if (cod.equals(ENTE_FEDERACAO)) {
            descricao = "Ente da Federação";
        } else if (cod.equals(ORGAO_ADM_DIRETA)) {
            descricao = "Órgão da Administração Direta";
        } else if (cod.equals(PAIS)) {
            descricao = "País";
        } else if (cod.equals(PESSOA_JURIDICA_PENDENTE)) {
        	descricao = "Pessoa Jurídica Pendente";
        } else if (cod.equals(FUNDO)) {
            descricao = "Fundo";
        }

        return descricao;
    }

    public LocalDateTime getDataHoraExclusao() {
        return this.dataHoraExclusao;
    }

    public void setDataHoraExclusao(final LocalDateTime dataHoraExclusao) {
        this.dataHoraExclusao = dataHoraExclusao;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getCod())
                .append(getDescricao())
                .toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        final DtoTipoPessoa other = (DtoTipoPessoa) obj;
        return new EqualsBuilder()
                .append(getCod(), other.getCod())
                .append(getDescricao(), other.getDescricao())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cod", getCod())
                .append("descricao", getDescricao())
                .append("dataHoraExclusao", getDataHoraExclusao())
                .toString();
    }
    
    @Override
    public int compareTo(final DtoTipoPessoa other) {
        return ObjectUtils.compare(getCod(), other.getCod());
    }
}

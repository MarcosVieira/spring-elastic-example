package br.gov.tcu.springelasticexample.servico.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class DtoTipoEnteFederacao implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * CUIDADO: essas constantes devem ser IGUAIS as definidas em TipoEnteFederacao.java
     */
    public static final int UNIAO = 1;
    public static final int UNIDADE_FEDERATIVA = 2;
    public static final int MUNICIPIO = 3;

    public static final String DESCR_UNIAO = "União";
    public static final String DESCR_UNIDADE_FEDERATIVA = "Unidade Federativa";
    public static final String DESCR_MUNICIPIO = "Município";

    private Integer cod;
    private String descricao;

    public static DtoTipoEnteFederacao criarDtoTipoEnteFederacaoUniao() {
        return getDtoTipo(UNIAO, DESCR_UNIAO);
    }

    public static DtoTipoEnteFederacao criarDtoTipoEnteFederacaoUnidadeFederativa() {
        return getDtoTipo(UNIDADE_FEDERATIVA, DESCR_UNIDADE_FEDERATIVA);
    }

    public static DtoTipoEnteFederacao criarDtoTipoEnteFederacaoMunicipio() {
        return getDtoTipo(MUNICIPIO, DESCR_MUNICIPIO);
    }

    private static DtoTipoEnteFederacao getDtoTipo(int cod, String descricao) {
        DtoTipoEnteFederacao dtoTipoEnteFederacaoUniao = new DtoTipoEnteFederacao();
        dtoTipoEnteFederacaoUniao.setCod(cod);
        dtoTipoEnteFederacaoUniao.setDescricao(descricao);

        return dtoTipoEnteFederacaoUniao;
    }

    public Integer getCod() {
        return this.cod;
    }

    public void setCod(final Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        if (StringUtils.isBlank(descricao) && getCod() != null) {
            if (cod == UNIAO) {
                descricao = DESCR_UNIAO;
            } else if (cod == UNIDADE_FEDERATIVA) {
                descricao = DESCR_UNIDADE_FEDERATIVA;
            } else if (cod == MUNICIPIO) {
                descricao = DESCR_MUNICIPIO;
            }
        }

        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

        final DtoTipoEnteFederacao other = (DtoTipoEnteFederacao) obj;
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
                .toString();
    }

}

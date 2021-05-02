package br.gov.tcu.springelasticexample.servico.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DtoUnidadeFederativa extends DtoEnteFederacao {
    private static final long serialVersionUID = 1L;

    private String sigla;
    private String regiao;
    private String nomeCapital;

    public DtoUnidadeFederativa() {
        final DtoTipoPessoa dtoTipoPessoa = new DtoTipoPessoa();
        dtoTipoPessoa.setCod(DtoTipoPessoa.ENTE_FEDERACAO);
        setDtoTipoPessoa(dtoTipoPessoa);
        setDtoTipoEnteFederacao(DtoTipoEnteFederacao.criarDtoTipoEnteFederacaoUnidadeFederativa());
    }

    public DtoUnidadeFederativa(String sigla) {
        this();
        this.setSigla(sigla);
    }

    public String getRegiao() {
        return this.regiao;
    }

    public void setRegiao(final String regiao) {
        this.regiao = regiao;
    }

    @Override
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeCapital() {
        return nomeCapital;
    }

    public void setNomeCapital(String nomeCapital) {
        this.nomeCapital = nomeCapital;
    }

    @Override
    public boolean temValorPreenchido() {
        return StringUtils.stripToNull(getNome()) != null || StringUtils.stripToNull(getSigla()) != null ||
                getCodNoIbge() != null;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getDtoTipoEnteFederacao())
                .append(getSigla())
                .append(getCodNoIbge())
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

        final DtoUnidadeFederativa other = (DtoUnidadeFederativa) obj;
        return new EqualsBuilder()
                .append(getDtoTipoEnteFederacao(), other.getDtoTipoEnteFederacao())
                .append(getSigla(), other.getSigla())
                .append(getCodNoIbge(), other.getCodNoIbge())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("tipoEnteFederacao", getDtoTipoEnteFederacao())
                .append("sigla", getSigla())
                .append("codNoIbge", getCodNoIbge())
                .toString();
    }

}

package br.gov.tcu.springelasticexample.servico.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class DtoMunicipio extends DtoEnteFederacao {
    private static final long serialVersionUID = 1L;

    private boolean capital;
    private DtoUnidadeFederativa dtoUnidadeFederativa;

    public DtoMunicipio() {
        final DtoTipoPessoa dtoTipoPessoa = new DtoTipoPessoa();
        dtoTipoPessoa.setCod(DtoTipoPessoa.ENTE_FEDERACAO);
        setDtoTipoPessoa(dtoTipoPessoa);
        setDtoTipoEnteFederacao(DtoTipoEnteFederacao.criarDtoTipoEnteFederacaoMunicipio());
    }

    public DtoMunicipio(Long id, DtoUnidadeFederativa dtoUnidadeFederativa) {
        this();
        this.setId(id);
        this.setDtoUnidadeFederativa(dtoUnidadeFederativa);
    }

    public DtoUnidadeFederativa getDtoUnidadeFederativa() {
        return dtoUnidadeFederativa;
    }

    public void setDtoUnidadeFederativa(final DtoUnidadeFederativa dtoUnidadeFederativa) {
        this.dtoUnidadeFederativa = dtoUnidadeFederativa;
    }

    public String getDescricaoIndicativoCapital() {
        return seCapitalEstado() ? "Sim" : "Não";
    }

    @Override
    public boolean temValorPreenchido() {
        return super.temValorPreenchido()
                || StringUtils.stripToNull(getSigla()) != null;
    }

    /**
     * Retorna a Sigla do Estado ao Qual pertence
     */
    @Override
    public String getSigla() {
        return getDtoUnidadeFederativa() == null ? null : getDtoUnidadeFederativa().getSigla();
    }

    public boolean seCapitalEstado() {
        return getId() != null
                && capital;
    }

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	@Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getNome())
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

        final DtoMunicipio other = (DtoMunicipio) obj;
        return new EqualsBuilder()
                .append(getNome(), other.getNome())
                .append(getCodNoIbge(), other.getCodNoIbge())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("sigla", getNome())
                .append("codNoIbge", getCodNoIbge())
                .append("descricaoTipoEnteFederacao", getDescricaoTipoEnteFederacao())
                .toString();
    }

}

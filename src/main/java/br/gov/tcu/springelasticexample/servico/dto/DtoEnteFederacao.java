package br.gov.tcu.springelasticexample.servico.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@JsonTypeInfo(use = Id.CLASS,
	include = JsonTypeInfo.As.PROPERTY,
	property = "type")
@JsonSubTypes({
	@Type(value = DtoMunicipio.class),
	@Type(value = DtoUniao.class),
	@Type(value = DtoUnidadeFederativa.class)
})
public class DtoEnteFederacao extends DtoPessoa {

	private static final long serialVersionUID = 1L;
    private DtoTipoEnteFederacao dtoTipoEnteFederacao;
    private Long codNoIbge;

    private List<String> nomesAlternativos = new ArrayList<>();


    public static final String BRASILIA = "Brasília";
    public static final String DISTRITO_FEDERAL = "Distrito Federal";

    public DtoTipoEnteFederacao getDtoTipoEnteFederacao() {
        return this.dtoTipoEnteFederacao;
    }

    protected final void setDtoTipoEnteFederacao(final DtoTipoEnteFederacao tipoEnteFederacao) {
        this.dtoTipoEnteFederacao = tipoEnteFederacao;
    }

    public Long getCodNoIbge() {
        if (this.codNoIbge != null && this.codNoIbge < 1) {
            this.codNoIbge = null;
        }

        return this.codNoIbge;
    }

    public void setCodNoIbge(final Long codNoIbge) {
        this.codNoIbge = codNoIbge;
    }

    /**
     * Deve ser sobrescrito pelas classes que de fato possuam sigla.
     *
     * @welder: Este método podia ser abstrado, ao invés de retornar null.
     */
    public String getSigla() {
    	return null;
    }

    public boolean isTipoEnteFederacaoUniao() {
        return DtoTipoEnteFederacao.UNIAO == getDtoTipoEnteFederacao().getCod();
    }

    public boolean isTipoEnteFederacaoEstado() {
        return DtoTipoEnteFederacao.UNIDADE_FEDERATIVA == getDtoTipoEnteFederacao().getCod();
    }

    public boolean isTipoEnteFederacaoMunicipio() {
        return DtoTipoEnteFederacao.MUNICIPIO == getDtoTipoEnteFederacao().getCod();
    }

    public boolean isTipoEnteFederacaoDistritoFederal() {
        return DtoTipoEnteFederacao.UNIDADE_FEDERATIVA == getDtoTipoEnteFederacao().getCod() && "DF".equals(getSigla());
    }

    public boolean isCapitalFederal() {
        return BRASILIA.equalsIgnoreCase(getNome());
    }

    public String getDescricaoTipoEnteFederacao() {
        String descricao = null;

        if (getDtoTipoEnteFederacao() == null) {
            descricao = "Tipo inválido: " + getDtoTipoEnteFederacao().toString();
        } else {
            descricao = getDtoTipoEnteFederacao().getDescricao();
        }

        return descricao;
    }

    public List<String> getNomesAlternativos() {
        return nomesAlternativos;
    }

    public void setNomesAlternativos(List<String> nomesAlternativos) {
        this.nomesAlternativos = nomesAlternativos;
    }

    /**
     * Seta a lista de nomes alternativos a partir de uma string com os nomes separados por ";"
     * @param nomesAlternativos uma string com nomes alternativos separados por ";"
     */
    public void setNomesAlternativos(final String nomesAlternativos) {
        setNomesAlternativos(StringUtils.isEmpty(nomesAlternativos) ?
                new ArrayList<String>() :
                Stream.of(nomesAlternativos.split(";"))
                        .map(String::trim)
                        .collect(Collectors.toList()));
    }

    public Class<?> getType() {
    	return this.getClass();
    }

    @Override
    public boolean temValorPreenchido() {

        return super.temValorPreenchido() || codNoIbge != null;
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

        final DtoEnteFederacao other = (DtoEnteFederacao) obj;
        return new EqualsBuilder()
                .append(getDtoTipoEnteFederacao(), other.getDtoTipoEnteFederacao())
                .append(getNome(), other.getNome())
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

package br.gov.tcu.springelasticexample.servico.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Representa uma pessoa, no nivel abstrato. A raiz da estrutura de pessoas.
 */
@Getter @Setter
@NoArgsConstructor
public class DtoPessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    public DtoPessoa(Long id, String nome, DtoTipoPessoa dtoTipoPessoa, boolean confiavel) {
    	this.id = id;
    	this.nome = nome;
    	this.dtoTipoPessoa = dtoTipoPessoa;
    	this.confiavel = confiavel;
    }
    
    private Long id;
    private String nome;
    private DtoTipoPessoa dtoTipoPessoa;
    private boolean confiavel = true;
    private boolean pessoaInvalidada;
    private String descricaoCriterioConfiabilidade;
    private LocalDate dataInvalidacao;
    public boolean isTipoEnteFederacao() {
        return DtoTipoPessoa.ENTE_FEDERACAO.equals(dtoTipoPessoa.getCod());
    }
    public boolean isTipoPessoaFisica() {
        return DtoTipoPessoa.PESSOA_FISICA.equals(dtoTipoPessoa.getCod());
    }
    public boolean isTipoPessoaJuridica() {
        return DtoTipoPessoa.PESSOA_JURIDICA.equals(dtoTipoPessoa.getCod());
    }
    public boolean isTipoOrgaoAdmDireta() {
        return DtoTipoPessoa.ORGAO_ADM_DIRETA.equals(dtoTipoPessoa.getCod());
    }
    public boolean isTipoPais() {
        return DtoTipoPessoa.PAIS.equals(dtoTipoPessoa.getCod());
    }
    public boolean isPersistido() {
        return getId() != null && getId().longValue() > 0;
    }
    public boolean temValorPreenchido() {
        return getId() != null || StringUtils.stripToNull(getNome()) != null;
    }
    public LocalDate getDataInvalidacao() {
        return dataInvalidacao;
    }
    public void setDataInvalidacao(LocalDate dataInvalidacao) {
        this.dataInvalidacao = dataInvalidacao;
    }
    public String getDataInvalidacaoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return (dataInvalidacao == null ? null : dataInvalidacao.format(formatter));
    }

    public void setDtoTipoPessoa(DtoTipoPessoa dtoTipoPessoa) {
        this.dtoTipoPessoa = dtoTipoPessoa;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getNome())
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

        final DtoPessoa other = (DtoPessoa) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .append(getNome(), other.getNome())
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("nome", getNome())
                .append("dtoTipoPessoa", getDtoTipoPessoa())
                .append("confiavel", isConfiavel())
                .toString();
    }

}

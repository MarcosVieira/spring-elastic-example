package br.gov.tcu.springelasticexample.servico.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Representa o Pais com o qual algum objeto de negocio do TCU se relaciona.
 */
public class DtoPais extends DtoPessoa {
    private static final long serialVersionUID = 1L;

    private String nomeNormalizado;
    private String codAlfaDois;
    private String codAlfaTres;
    private Integer codIsoNumerico;
    private LocalDateTime dataHoraExclusao;
    private String descrNacionalidade;
    private Integer numRfb;
    private Integer numDdi;
    private List<String> nomesAlternativos;

    public static final String BRASIL = "Brasil";
    public static final String BRASIL_SIGLA_TRES_LETRAS = "BRA";
    public static final Integer BRASIL_NUM_ISO = Integer.parseInt("76");

    public DtoPais() {
        setDtoTipoPessoa(DtoTipoPessoa.criarDtoTipoPessoaPais());
    }

    public LocalDateTime getDataHoraExclusao() {
        return this.dataHoraExclusao;
    }


    public String getDataHoraExclusaoString() {
        return dataHoraExclusao == null ? null : dataHoraExclusao .format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
    }

    public void setDataHoraExclusao(final LocalDateTime dataHoraExclusao) {
        this.dataHoraExclusao = dataHoraExclusao;

    }

    public String getCodAlfaTres() {
        return this.codAlfaTres;
    }

    public void setCodAlfaTres(final String codAlfaTres) {
        this.codAlfaTres = codAlfaTres;

    }

    public String getCodAlfaDois() {
        return this.codAlfaDois;
    }

    public void setCodAlfaDois(final String codAlfaDois) {
        this.codAlfaDois = codAlfaDois;

    }

    public Integer getCodIsoNumerico() {
        return this.codIsoNumerico;
    }

    public void setCodIsoNumerico(final Integer codIsoNumerico) {
        this.codIsoNumerico = codIsoNumerico;
    }

    public String getDescrNacionalidade() {
        return descrNacionalidade;
    }

    public void setDescrNacionalidade(String descrNacionalidade) {
        this.descrNacionalidade = descrNacionalidade;
    }

    public String getNomeNormalizado() {
        return nomeNormalizado;
    }

    public void setNomeNormalizado(String nomeNormalizado) {
        this.nomeNormalizado = nomeNormalizado;
    }
    
    public Integer getNumRfb() {
        return this.numRfb;
    }

    public void setNumRfb(final Integer numRfb) {
        this.numRfb = numRfb;
    }    
    
    public Integer getNumDdi() {
        return this.numDdi;
    }

    public void setNumDdi(final Integer numDdi) {
        this.numDdi = numDdi;
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
    public boolean isBrasil() {
        return getId() != null && BRASIL.equalsIgnoreCase(getNome()) &&
                BRASIL_SIGLA_TRES_LETRAS.equalsIgnoreCase(getCodAlfaTres()) &&
                BRASIL_NUM_ISO.intValue() == getCodIsoNumerico().intValue();
    }

    public static DtoPais criarDtoBrasil() {
        DtoPais dtoBrasil = new DtoPais();
        dtoBrasil.setId(910001L); // FIXME: Resolver incidente, mas tratar melhor depois.
        dtoBrasil.setNome(BRASIL);
        dtoBrasil.setCodAlfaTres(BRASIL_SIGLA_TRES_LETRAS);
        dtoBrasil.setCodIsoNumerico(BRASIL_NUM_ISO);

        return dtoBrasil;
    }

    @Override
    public boolean temValorPreenchido() {
        return StringUtils.stripToNull(getNome()) != null || StringUtils.stripToNull(getCodAlfaDois()) != null ||
                StringUtils.stripToNull(getCodAlfaTres()) != null || getCodIsoNumerico() != null || 
                getNumRfb() != null || getNumDdi() != null || getId() != null;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getId())
                .append(getNome())
                .append(getCodIsoNumerico())
                .append(getCodAlfaDois())
                .append(getCodAlfaTres())
                .append(getNumRfb())
                .append(getNumDdi())
                .append(getNomesAlternativos())
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

        final DtoPais other = (DtoPais) obj;
        return new EqualsBuilder()
                .append(getId(), other.getId())
                .append(getNome(), other.getNome())
                .append(getCodIsoNumerico(), other.getCodIsoNumerico())
                .append(getCodAlfaDois(), other.getCodAlfaDois())
                .append(getCodAlfaTres(), other.getCodAlfaTres())
                .append(getNumRfb(), other.getNumRfb())
                .append(getNumDdi(), other.getNumDdi())
                .append(getNomesAlternativos(), other.getNomesAlternativos())
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", getId())
                .append("nome", getNome())
                .append("codAlfaDois", getCodAlfaDois())
                .append("codAlfaTres", getCodAlfaTres())
                .append("codIsoNumerico", getCodIsoNumerico())
                .append("dataHoraExclusao", getDataHoraExclusao())
                .append("numRfb", getNumRfb())
                .append("numDdi", getNumDdi())
                .append("nomesAlternativos", getNomesAlternativos())
                .toString();
    }

}

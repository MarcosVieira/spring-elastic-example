package br.gov.tcu.springelasticexample.servico.dto;

public class DtoUniao extends DtoEnteFederacao {

    private static final long serialVersionUID = 1L;

    public DtoUniao() {
        final DtoTipoPessoa dtoTipoPessoa = new DtoTipoPessoa();
        dtoTipoPessoa.setCod(DtoTipoPessoa.ENTE_FEDERACAO);
        setDtoTipoPessoa(dtoTipoPessoa);
        setDtoTipoEnteFederacao(DtoTipoEnteFederacao.criarDtoTipoEnteFederacaoUniao());
    }

	@Override
	public String getSigla() {
		return null;
	}

}

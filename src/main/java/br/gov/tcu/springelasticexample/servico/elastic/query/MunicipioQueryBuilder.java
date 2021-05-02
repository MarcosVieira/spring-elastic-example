package br.gov.tcu.springelasticexample.servico.elastic.query;

public class MunicipioQueryBuilder extends PessoasGeosQueryBuilder {

    /**
     * Monta a query ElasticSearch para recuperar municípios pela sigla da uf.
     *
     * @param sigla sigla da uf a ser pesquisada.
     * @return query ElasticSearch para pesquisa pela sigla da uf do município.
     */
    public String porSiglaUf(final String sigla) {
        return "{\n"+
                " \"query\":{\n" +
                "  \"term\":{\"municipio.siglaUf\":\"" + sigla + "\"}\n" +
                " }\n" +
                "}\n";
    }

}

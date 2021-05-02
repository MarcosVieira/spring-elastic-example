package br.gov.tcu.springelasticexample.servico.elastic.query;

public class UfQueryBuilder extends PessoasGeosQueryBuilder {

    /**
     * Monta a query ElasticSearch para recuperar uf pela sigla.
     *
     * @param sigla sigla da uf a ser pesquisada.
     * @return query ElasticSearch para pesquisa pela sigla de uma uf.
     */
    public String porSigla(final String sigla) {
        return "{\n"+
                " \"query\":{\n" +
                "  \"term\":{\"uf.siglaUf\":\"" + sigla + "\"}\n" +
                " }\n" +
                "}\n";
    }

}

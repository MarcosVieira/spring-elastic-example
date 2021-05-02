package br.gov.tcu.springelasticexample.servico.elastic.query;

public class PaisQueryBuilder extends PessoasGeosQueryBuilder {

    /**
     * Monta a query ElasticSearch para recuperar país pela sigla, podendo ser pela sigla de duas ou de três letras.
     *
     * @param sigla sigla do país a ser pesquisada, de duas ou de três letras.
     * @return query ElasticSearch para pesquisa pela sigla de um país.
     */
    public String porSigla(final String sigla) {
        return "{\n"+
                " \"query\":{\n" +
                "  \"multi_match\":{\n" +
                "   \"query\":\"" + sigla + "\",\n" +
                "   \"fields\":[\"pais.codAlfaDois\",\"pais.codAlfaTres\"]\n" +
                "   }\n" +
                "  }\n" +
                "}\n";
    }

}

package br.gov.tcu.springelasticexample.servico.elastic.query;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class PessoasGeosQueryBuilder {

    /**
     * Monta a query ElasticSearch para recuperar os documentos de um índice/alias.
     *
     * @return query ElasticSearch para recuperar a lista de todos os documentos de um indice/alias.
     */
    public String todos() {
        return "{\n" +
               "  \"query\":{\n" +
               "   \"match_all\":{}\n" +
               "  }\n" +
               "}\n";
    }

    /**
     * Query ElasticSearch para recuperar pessoa pelo id.
     *
     * @param id id da pessoa.
     * @return query ElasticSearch para pesquisa pelo id de uma pessoa.
     */
    public String porId(final Long id) {
        return "{\n" +
               "  \"query\":{\n" +
               "   \"term\":{\"id\":" + id + "}\n" +
               "  }\n" +
               "}\n";
    }

    /**
     * Monta a query ElasticSearch para recuperar pessoa pelo nome, no campo "nome".
     *
     * @param nome nome da pessoa.
     * @return query ElasticSearch para pesquisa pelo nome de uma pessoa.
     */
    public String porNome(final String nome) {
        return "{\n" +
               "  \"query\":{\n" +
               "   \"match\":{\"nome\":\"" + nome + "\"}\n" +
               "  }\n" +
               "}\n";
    }

    /**
     * Monta a query ElasticSearch para recuperar pessoa pela parte do nome.
     * Mais de uma parte do nome podem estar na string, separados por espaços, vírgula, ...
     * Os campos pesquisados são "nome" e "nomesAlternativos".
     * Wildcards (* e ?) podem ser usados para aumentar a abrangência da pesquisa.
     *
     * @param partesNome partes do nome da pessoa.
     * @return query ElasticSearch para pesquisa pelas partes do nome de uma pessoa.
     */
    public String porParteNome(final String partesNome) {

        // trata o "parte nome" se informado em partes
        String parteNomeAux = Stream.of(partesNome.split("\\s"))
                .map(String::trim)
                .collect(Collectors.joining(" "));

        return "{\n" +
                "  \"query\":{\n" +
                "   \"query_string\":{\"query\":\"" + parteNomeAux + "\",\"fields\":[\"nome.fullText\",\"nomesAlternativos\"]}\n" +
                "  }\n" +
                "}\n";
    }

}

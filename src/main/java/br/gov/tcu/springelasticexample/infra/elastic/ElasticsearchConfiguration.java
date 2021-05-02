package br.gov.tcu.springelasticexample.infra.elastic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "br.gov.tcu.springelasticexample.*")
public class ElasticsearchConfiguration {

    @Value("${elastic.indice.pessoas-geos-paises}")
    private String indicePaises;

    @Value("${elastic.indice.pessoas-geos-ufs}")
    private String indiceUfs;

    @Value("${elastic.indice.pessoas-geos-municipios}")
    private String indiceMunicipios;

    @Bean
    public String indicePaises() {
       if (this.indicePaises != null) {
          return this.indicePaises;
       }
       throw new IllegalArgumentException();
    }

    @Bean
    public String indiceUfs() {
       if (this.indiceUfs != null) {
          return this.indiceUfs;
       }
       throw new IllegalArgumentException();
    }

    @Bean
    public String indiceMunicipios() {
       if (this.indiceMunicipios != null) {
          return this.indiceMunicipios;
       }
       throw new IllegalArgumentException();
    }

}
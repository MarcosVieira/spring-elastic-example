package br.gov.tcu.springelasticexample.servico.elastic.repository;

import br.gov.tcu.springelasticexample.servico.elastic.dto.Municipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipioElasticRepository extends PagingAndSortingRepository<Municipio, Long> {
    Optional<Municipio> findById(final Long id);
    Page<Municipio> findByName(final String name, final Pageable pageable);
}

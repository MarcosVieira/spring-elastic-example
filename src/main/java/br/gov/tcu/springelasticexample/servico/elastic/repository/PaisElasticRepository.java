package br.gov.tcu.springelasticexample.servico.elastic.repository;

import br.gov.tcu.springelasticexample.servico.elastic.dto.Pais;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisElasticRepository extends PagingAndSortingRepository<Pais, Long> {
    Optional<Pais> findById(final Long id);
    Page<Pais> findByName(final String name, final Pageable pageable);
}

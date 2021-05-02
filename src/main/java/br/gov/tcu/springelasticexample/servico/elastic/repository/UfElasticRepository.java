package br.gov.tcu.springelasticexample.servico.elastic.repository;

import br.gov.tcu.springelasticexample.servico.elastic.dto.Uf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UfElasticRepository extends PagingAndSortingRepository<Uf, Long> {
    Optional<Uf> findById(final Long id);
    Page<Uf> findByName(final String name, final Pageable pageable);
}

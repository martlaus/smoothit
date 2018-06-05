package it.smooth.components.repository;


import it.smooth.components.model.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends PagingAndSortingRepository<Component, Long> {

  Page<Component> findByNameContains(String term, Pageable pageable);

}
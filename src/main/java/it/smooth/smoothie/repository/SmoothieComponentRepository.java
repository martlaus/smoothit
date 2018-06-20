package it.smooth.smoothie.repository;


import it.smooth.smoothie.model.SmoothieComponent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmoothieComponentRepository extends PagingAndSortingRepository<SmoothieComponent, Long> {


}
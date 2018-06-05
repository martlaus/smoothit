package it.smooth.smoothie.repository;


import it.smooth.smoothie.model.Smoothie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmoothieRepository extends PagingAndSortingRepository<Smoothie, Long> {


}
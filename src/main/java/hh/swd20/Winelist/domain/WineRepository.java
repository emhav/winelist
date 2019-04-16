package hh.swd20.Winelist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WineRepository extends CrudRepository<Wine, Long> {

  List<Wine> findByName(String name);
  
}

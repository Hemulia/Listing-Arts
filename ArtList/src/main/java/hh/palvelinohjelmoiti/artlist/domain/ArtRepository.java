package hh.palvelinohjelmoiti.artlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtRepository extends CrudRepository<Art, Long> {
	List<Art> findByName(String name);

}

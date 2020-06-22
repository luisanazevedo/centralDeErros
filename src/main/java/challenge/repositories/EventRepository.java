package challenge.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge.entities.Event;

public interface EventRepository extends JpaRepository<Event,Long>{
	
	Optional<Event> findById(Long id);
	

}

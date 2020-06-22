package challenge.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge.entities.Event;

public interface EventRepository extends JpaRepository<Event,Long>{
	
	Optional<Event> findById(Long id);
	
	//List<Event> findByLevel(String level);
	
	//List<Event> findByDecription(String description);
	
	//List<Event> findByLog(String log);
	
	//List<Event> findByOrigin(String origin);
	
	//List<Event> findByDate(LocalDateTime date);
	
	

}

package challenge.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge.entities.Event;
import challenge.entities.enums.Level;

public interface EventRepository extends JpaRepository<Event,Long>{
	
	Optional<Event> findById(Long id);
	
	List<Event> findByOrigin(String origin);
	
	List<Event> findByLog(String log);
	
	List<Event> findByLevel(Level level);
	
	List<Event> findByDescription(String description);
	
	List<Event> findByDate(LocalDateTime date);	
	

}

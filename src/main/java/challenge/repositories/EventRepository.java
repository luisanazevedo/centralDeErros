package challenge.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import challenge.entities.Event;
import challenge.entities.enums.Level;

public interface EventRepository extends JpaRepository<Event,Long>{
	
	Optional<Event> findById(Long id);
	
	@Query(value="SELECT * FROM Events e WHERE LOWER(e.origin) like %:origin%", nativeQuery = true)
	List<Event> findByOrigin(@Param("origin") String origin);
	
	@Query(value="SELECT * FROM Events e WHERE LOWER(e.log) like %:log%", nativeQuery = true)
	List<Event> findByLog(@Param("log")String log);
	
	@Query(value="SELECT * FROM Events e WHERE LOWER(e.level) like %:level%", nativeQuery = true)
	List<Event> findByLevel(@Param("level")Level level);
	
	@Query(value="SELECT * FROM Events e WHERE LOWER(e.description) like %:description%", nativeQuery = true)
	List<Event> findByDescription(@Param("description") String description);
	
	@Query(value="SELECT * FROM Events e WHERE LOWER(e.created_at) like %:date%", nativeQuery = true)
	List<Event> findByDate(@Param("date")LocalDateTime date);	
	
	@Query(value="SELECT * FROM Events ORDER BY :order ASC", nativeQuery = true)
	List<Event> orderBy (@Param("order")String order);

}

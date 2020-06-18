package challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import challenge.entities.Event;

public interface EventRepository extends JpaRepository<Event,Long>{

}

package challenge.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import challenge.dto.EventDTO;
import challenge.entities.Event;
import challenge.mapper.EventMapper;
import challenge.repositories.EventRepository;
import challenge.services.exceptions.DatabaseException;
import challenge.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public List<EventDTO> findAll() {
		return (EventMapper.eventListToEventDTOList(eventRepository.findAll()));
	}

	public EventDTO findById(Long id) {

		Optional<Event> optionalEvent = eventRepository.findById(id);
		return EventMapper.eventToEventDTO(optionalEvent.orElseThrow(() -> new ResourceNotFoundException(id)));
	}
	
	public List<Event> findByDescription(String description){
		return eventRepository.findByDescription(description);
	}
	
	public List<Event> orderBy(String order){
		return eventRepository.orderBy(order);
	}

	public EventDTO insert(Event event) {
		return EventMapper.eventToEventDTO(eventRepository.save(event));
	}

	public void delete(Long id) {
		try {
			eventRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}

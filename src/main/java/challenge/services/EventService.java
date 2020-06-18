package challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import challenge.entities.Event;
import challenge.repositories.EventRepository;
import challenge.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	public Event findById(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
		return optionalEvent.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
}

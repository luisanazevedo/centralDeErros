package challenge.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import challenge.entities.Event;
import challenge.repositories.EventRepository;
import challenge.services.exceptions.DatabaseException;
import challenge.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	public Event findById(Long id) {

		Optional<Event> optionalEvent = eventRepository.findById(id);
		return optionalEvent.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Event insert(Event obj) {
		return eventRepository.save(obj);
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

	public Event update(Long id, Event obj) {
		try {
			Event entity = eventRepository.getOne(id);
			updateData(entity, obj);
			return eventRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Event entity, Event obj) {
		entity.setLevel(obj.getLevel());
		entity.setDescription(obj.getDescription());
		entity.setLog(obj.getLog());
		entity.setOrigin(obj.getOrigin());
	}

}

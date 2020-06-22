package challenge.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import challenge.dto.EventDTO;
import challenge.entities.Event;
import challenge.mapper.EventMapper;
import challenge.services.EventService;

@RestController
@RequestMapping(value = "/events")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public ResponseEntity<List<Event>> findAll(){
		List<EventDTO> list = eventService.findAll();
		return ResponseEntity.ok().body(EventMapper.eventDTOListToeventList(list));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Event> findById(@PathVariable Long id){
		EventDTO eventDTO = eventService.findById(id);
		return ResponseEntity.ok().body(EventMapper.eventDTOToEvent(eventDTO));
	}	
	
	@PostMapping
	public ResponseEntity<Event> insert(@RequestBody EventDTO eventDTO){
		eventDTO = eventService.insert(EventMapper.eventDTOToEvent(eventDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(eventDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(EventMapper.eventDTOToEvent(eventDTO));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		eventService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	/*@PutMapping(value = "/{id}")
	public ResponseEntity<Event> update(@PathVariable Long id, @RequestBody EventDTO eventDTO){
		Event event = eventService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}*/
}

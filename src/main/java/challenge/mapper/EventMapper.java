package challenge.mapper;

import java.util.List;
import java.util.stream.Collectors;

import challenge.dto.EventDTO;
import challenge.entities.Event;

public class EventMapper {
	
	public EventMapper() {
		super();
	}
	
	public static EventDTO eventToEventDTO(Event event) {
		EventDTO eventDTO = new EventDTO();
		
		eventDTO.setId(event.getId());
		eventDTO.setOrigin(event.getOrigin());
		eventDTO.setLevel(event.getLevel());
		eventDTO.setDescription(event.getDescription());
		eventDTO.setDate(event.getDate());
		
		return eventDTO;
	}
	
	public static Event eventDTOToEvent(EventDTO eventDTO) {
		Event event= new Event();
		
		event.setId(eventDTO.getId());
		event.setOrigin(eventDTO.getOrigin());
		event.setLevel(eventDTO.getLevel());
		event.setDescription(eventDTO.getDescription());
		event.setDate(eventDTO.getDate());
		
		return event;
	}
	
	public static List<EventDTO> eventListToEventDTOList(List<Event> events){
		return events.stream().map(event -> EventMapper.eventToEventDTO(event)).collect(Collectors.toList());
	}
	
	public static List<Event> eventDTOListToEventList(List<EventDTO> eventsDTO){
		return eventsDTO.stream().map(eventDTO -> EventMapper.eventDTOToEvent(eventDTO)).collect(Collectors.toList());
	}

}

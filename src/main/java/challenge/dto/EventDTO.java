package challenge.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import challenge.entities.enums.Level;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Level level;
	
	private String description;
	
	private String origin;
	
	private LocalDateTime date;

}

package challenge.entities;

import java.io.Serializable;
import java.time.Instant;

import challenge.entities.enums.Level;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Eventos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	@Getter @ Setter private Level level;
	@Getter @ Setter private String descricao;
	@Getter @ Setter private String origem;
	@Getter @ Setter private Instant data;
	

}

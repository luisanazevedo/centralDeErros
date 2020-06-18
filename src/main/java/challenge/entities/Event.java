package challenge.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import challenge.entities.enums.Level;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
@Entity @Table(name = "events") @EntityListeners(AuditingEntityListener.class)
public class Event implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter private Long id;
	@Getter @ Setter private Level level;
	@Getter @ Setter private String description;
	@Getter @ Setter private String log;
	@Getter @ Setter private String origin;
	@Getter @ Setter private Instant date;
	@Column(name="created_at")
	@Getter @ Setter private Instant createdAt;
	

}

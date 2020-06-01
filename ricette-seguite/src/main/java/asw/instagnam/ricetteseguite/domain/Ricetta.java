package asw.instagnam.ricetteseguite.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* Ricetta (in formato breve). */
@Entity
@Data @NoArgsConstructor
public class Ricetta {

	@Id
	private Long id;

	private String titolo;
	private String autore; 

	public Ricetta(Long id, String autore, String titolo) {
		this();
		this.id = id;
		this.autore = autore;
		this.titolo = titolo;
	}
}

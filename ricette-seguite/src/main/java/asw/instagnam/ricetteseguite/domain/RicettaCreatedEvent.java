package asw.instagnam.ricetteseguite.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RicettaCreatedEvent implements DomainEvent {

	private Long id;
	private String autore;
	private String titolo;

}

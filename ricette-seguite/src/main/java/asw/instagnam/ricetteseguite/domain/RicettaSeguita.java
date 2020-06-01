package asw.instagnam.ricetteseguite.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor
@JsonIgnoreProperties(value = { "utenteFollower" })
public class RicettaSeguita {

	@Id
	@GeneratedValue
	private Long id;

	private String utenteFollower;
	private Long idRicetta;
	private String titoloRicetta;
	private String autoreRicetta;

	public RicettaSeguita(Long idRicetta, String titoloRicetta, String autoreRicetta, String utenteFollower) {
		this.idRicetta = idRicetta;
		this.titoloRicetta = titoloRicetta;
		this.autoreRicetta = autoreRicetta;
		this.utenteFollower = utenteFollower;
	}


}

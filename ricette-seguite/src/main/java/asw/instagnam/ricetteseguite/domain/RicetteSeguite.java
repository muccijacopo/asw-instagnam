package asw.instagnam.ricetteseguite.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data @NoArgsConstructor
public class RicetteSeguite {

	@Id
	@GeneratedValue
	private Long id;
	@ElementCollection()
	@CollectionTable(name="connessione", joinColumns=@JoinColumn(name="follower"))
	private Set<String> utenteFollower;
	private String idRicetta;
	private String autoreRicetta;
	private String titoloRicetta;

}

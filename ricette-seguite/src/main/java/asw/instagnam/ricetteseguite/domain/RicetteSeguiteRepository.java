package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface RicetteSeguiteRepository extends CrudRepository<RicettaSeguita, Long> {
    public Collection<RicettaSeguita> findAllByUtenteFollower(String utente);
}

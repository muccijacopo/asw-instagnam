package asw.instagnam.common.api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RicettaCreatedEvent implements DomainEvent {
    private String autore;
    private String titolo;

}

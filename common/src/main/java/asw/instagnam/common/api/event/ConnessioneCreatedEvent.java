package asw.instagnam.common.api.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnessioneCreatedEvent implements DomainEvent {

    private Long id;
    private String follower;
    private String followed;

}

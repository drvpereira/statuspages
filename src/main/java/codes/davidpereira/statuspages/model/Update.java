package codes.davidpereira.statuspages.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Update {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;

    @Enumerated(EnumType.ORDINAL)
    private UpdateType type;

    private LocalDateTime timestamp;

    private String description;

}

package codes.davidpereira.statuspages.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Incident {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    private String title;

    private LocalDate date;

    private String description;

    @OneToMany(mappedBy = "incident")
    private List<Update> updates;

}

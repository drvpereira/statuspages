package codes.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@SQLDelete(sql ="update incident set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class Incident {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    private String title;

    private LocalDate date;

    private String description;

    @OneToMany(mappedBy = "incident")
    private List<IncidentUpdate> updates;

}

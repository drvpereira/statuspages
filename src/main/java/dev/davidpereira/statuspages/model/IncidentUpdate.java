package dev.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Entity
@SQLDelete(sql ="update incident_update set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class IncidentUpdate implements Persistable<Long> {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;

    @Enumerated(EnumType.ORDINAL)
    private UpdateType type;

    private LocalDateTime timestamp;

    private String description;

    @Override
    public Optional<Long> getOptionalId() {
        return ofNullable(id);
    }

}

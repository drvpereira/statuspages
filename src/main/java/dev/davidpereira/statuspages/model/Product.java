package dev.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Entity
@SQLDelete(sql ="update product set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class Product implements Persistable<Long> {

    @Id
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private HealthStatus status;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ProductGroup group;

    @OneToMany
    private List<HealthCheckConfig> healthChecks;

    @Override
    public Optional<Long> getId() {
        return ofNullable(id);
    }

}

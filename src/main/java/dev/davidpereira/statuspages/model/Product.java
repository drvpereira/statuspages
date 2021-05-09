package dev.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@SQLDelete(sql ="update product set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class Product {

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

}

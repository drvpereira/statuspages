package dev.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Entity
@SQLDelete(sql ="update product_group set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class ProductGroup implements Persistable<Long> {

    @Id
    private Long id;

    private String name;

    @Override
    public Optional<Long> getId() {
        return ofNullable(id);
    }

}

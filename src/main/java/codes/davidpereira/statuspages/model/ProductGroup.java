package codes.davidpereira.statuspages.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SQLDelete(sql ="update product_group set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class ProductGroup {

    @Id
    private Long id;

    private String name;

}

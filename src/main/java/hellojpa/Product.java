package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String name;

}

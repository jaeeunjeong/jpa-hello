package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String username;

    @ManyToMany(mappedBy = "products")
    private List<Member> members = new ArrayList<>();
}

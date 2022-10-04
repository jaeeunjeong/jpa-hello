package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {

    @Id
    @GeneratedValue
    @Column(name = "LOCKER_ID")
    private Long Locker;

    private String name;

    @OneToOne(mappedBy = "locker")
    @JoinColumn
    private Member member;

}

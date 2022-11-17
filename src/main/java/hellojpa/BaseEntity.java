package hellojpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@Data
@MappedSuperclass
public class BaseEntity {

    @Column(name = "INSERT_MEMBER")
    private String createBy;

    private LocalDateTime localDateTime;

    @Column(name = "UPDATE_MEMBER")
    private String lastModified;

    private LocalDateTime lastModifiedDate;
}

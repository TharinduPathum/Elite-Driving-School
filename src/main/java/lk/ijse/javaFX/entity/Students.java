package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Students {

    @Id
    private String s_id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false, unique = true)
    private String nic;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private Date registrationDate;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<CourseEnrollment> studentCourseDetails;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Lessons> lessons;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private List<Payments> payments;
}

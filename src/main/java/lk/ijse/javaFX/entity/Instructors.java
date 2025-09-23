package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "instructor")
public class Instructors {

    @Id
    @Column
    private String i_id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false, unique = true)
    private String nic;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String availability;

    @OneToMany(
            mappedBy = "instructor",
            cascade = CascadeType.ALL
    )
    private List<Lessons> lessons;

    @OneToMany(
            mappedBy = "instructor",
            cascade = CascadeType.ALL
    )
    private List<Course> courses;
}

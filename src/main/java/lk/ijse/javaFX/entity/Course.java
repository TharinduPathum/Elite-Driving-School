package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column
    private String  c_id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private double fee;

    @ManyToOne
    @JoinColumn(name ="i_id", referencedColumnName = "i_id")
    private Instructors instructor;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private List<CourseEnrollment> courseEnrollments;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private List<Lessons> lessons;

}

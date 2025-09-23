package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Course_enrollment")
public class CourseEnrollment {

    @Id
    @Column
    private String std_course_id;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "s_id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    private Course course;

    @Column
    private Date enrollmentDate;

    @Column
    private String status;
}

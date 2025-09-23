package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lessons {

    @Id
    @Column
    private String l_id;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "s_id")
    private Students students;

    @ManyToOne
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "i_id", referencedColumnName = "i_id")
    private Instructors instructors;

    @Column
    private Date date;

    @Column
    private Time startTime;

    @Column
    private Time endTime;

    @Column
    private String status;
}

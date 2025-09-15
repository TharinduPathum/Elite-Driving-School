package lk.ijse.javaFX.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lessons_table")
public class Lessons {

    @Id
    private int lessonId;

    @Column
    private int instructorId;

    @Column
    private Date date;

    @Column
    private String time;
}

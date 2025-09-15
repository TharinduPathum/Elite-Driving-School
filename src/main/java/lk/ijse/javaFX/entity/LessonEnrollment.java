package lk.ijse.javaFX.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lesson_enrollment")
public class LessonEnrollment {


    private int lessonId;
    private int studentId;
}

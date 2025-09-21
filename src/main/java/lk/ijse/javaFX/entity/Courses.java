package lk.ijse.javaFX.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course_table")
public class Courses {

    @Id
    private String  c_id;

    @Column(nullable = false,name = "course_name")
    private String name;

    @Column
    private String duration;

    @Column(nullable = false)
    private double fee;

}

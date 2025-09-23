package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoursesDTO {
    private String c_id;
    private String name;
    private String duration;
    private double fee;
    private String description;
    private String i_id;
    @Builder.Default
    private ArrayList<CourseEnrollmentDTO> studentCourseDetails = new ArrayList<>();
    @Builder.Default
    private ArrayList<LessonsDTO> lessons = new ArrayList<>();
}

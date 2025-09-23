package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseEnrollmentDTO {

    private String std_course_id;
    private String c_id;
    private String s_id;
    private Date date;
    private String status;
}

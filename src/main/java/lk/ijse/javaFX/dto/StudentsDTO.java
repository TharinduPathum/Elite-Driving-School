package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentsDTO {
    private String s_id;
    private String name;
    private String nic;
    private String email;
    private String phone;
    private Date registrationDate;
    private List<String> courseIds;
    @Builder.Default
    private ArrayList<CourseEnrollmentDTO> studentCourseDetails = new ArrayList<>();
    @Builder.Default
    private ArrayList<LessonsDTO> lessons =new ArrayList<>();
    @Builder.Default
    private ArrayList<PaymentsDTO> payments =new ArrayList<>();

}

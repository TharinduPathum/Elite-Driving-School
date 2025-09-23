package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
public class InstructorsDTO {
    private String i_id;
    private String name;
    private String nic;
    private String email;
    private String phone;
    private String specialization;
    private String availability;
    @Builder.Default
    private ArrayList<LessonsDTO> lessons = new  ArrayList<>();
    @Builder.Default
    private ArrayList<CoursesDTO> courses = new ArrayList<>();

}

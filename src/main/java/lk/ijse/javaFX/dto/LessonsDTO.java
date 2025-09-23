package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LessonsDTO {
    private String  l_id;
    private String  i_id;
    private String  s_id;
    private String  c_id;
    private Date date;
    private Time startTime;
    private Time endTime;

}

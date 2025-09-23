package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UsersDTO {
    private String u_id;
    private String userName;
    private String passWord;
    private String role;
    private String status;

}

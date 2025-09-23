package lk.ijse.javaFX.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentsDTO {
    private String p_id;
    private String s_id;
    private double amount;
    private Date date;
    private String paymentMethod;
    private String status;
}

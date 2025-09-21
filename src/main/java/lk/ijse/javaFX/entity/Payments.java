package lk.ijse.javaFX.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment_table")
public class Payments {

    @Id
    private String p_id;

    @Column
    private String s_id;

    @Column
    private double amount;

    @Column
    private Date date;
}

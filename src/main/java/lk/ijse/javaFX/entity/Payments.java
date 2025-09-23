package lk.ijse.javaFX.entity;

import jakarta.persistence.*;
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
@Table(name = "payment")
public class Payments {

    @Id
    @Column
    private String p_id;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "s_id")
    private Students student;

    @Column
    private Date date;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String status;
}

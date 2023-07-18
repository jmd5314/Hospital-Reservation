package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter @Setter
public class Reserve {
    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private Date date;

}

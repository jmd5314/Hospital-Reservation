package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Treatment {
    @Id
    @GeneratedValue
    @Column(name = "treatment_id")
    private Long id;
    private TreatmentStatus status;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}

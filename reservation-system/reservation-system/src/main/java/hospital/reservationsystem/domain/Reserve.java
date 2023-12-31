package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@Getter @Setter
public class Reserve {
    @Id @GeneratedValue
    @Column(name = "reserve_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    private LocalDateTime date;

    //==생성 메서드 ==//
    public static Reserve createReserve(Patient patient, Doctor doctor,LocalDateTime date){
        Reserve reserve = new Reserve();
        reserve.setPatient(patient);
        reserve.setDoctor(doctor);
        reserve.setDate(date);
        return reserve;
    }

}

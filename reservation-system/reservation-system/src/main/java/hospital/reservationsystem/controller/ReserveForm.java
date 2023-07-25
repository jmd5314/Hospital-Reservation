package hospital.reservationsystem.controller;

import hospital.reservationsystem.domain.Doctor;
import hospital.reservationsystem.domain.Patient;
import hospital.reservationsystem.domain.ReserveStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class ReserveForm {
    private LocalDateTime date ;
    private Long patientId;
}

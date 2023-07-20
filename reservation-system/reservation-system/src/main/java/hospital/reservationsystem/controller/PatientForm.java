package hospital.reservationsystem.controller;

import hospital.reservationsystem.domain.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientForm {
    private Long id;
    @NotEmpty(message = "환자 이름은 필수입니다")
    private String name;
    private int age;
    private Gender gender;
}

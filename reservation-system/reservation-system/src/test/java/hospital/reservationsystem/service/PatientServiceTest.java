package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Gender;
import hospital.reservationsystem.domain.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PatientServiceTest {
    @Autowired PatientService patientService;
@Test
@Rollback(value = false)
public void 환자검증 () throws Exception{
    //given
    Patient patient = new Patient();
    patient.setGender(Gender.Female);
    patient.setName("조믿음");
    patient.setAge(29);
    patientService.join(patient);

 }
}
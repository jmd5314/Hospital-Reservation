package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Address;
import hospital.reservationsystem.domain.Gender;
import hospital.reservationsystem.domain.Patient;
import hospital.reservationsystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    //환자 등록
    @Transactional
    public Long save(Patient patient){
        patientRepository.save(patient);
        return patient.getId();
    }
    //환자 조회
    public Patient findPatient(Long id){
        return patientRepository.findOne(id);
    }
    public List<Patient> findPatients(){
        return patientRepository.findAll();
    }
    //환자 정보 수정
    @Transactional
    public void updatePatient(Long id, String name, int age, Gender gender){
        Patient patient = patientRepository.findOne(id);
        patient.setId(id);
        patient.setName(name);
        patient.setAge(age);
        patient.setGender(gender);
    }
}

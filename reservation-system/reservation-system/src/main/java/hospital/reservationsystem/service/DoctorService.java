package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Doctor;
import hospital.reservationsystem.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Long save(Doctor doctor){
        doctorRepository.save(doctor);
        return doctor.getId();
    }
    public Doctor findDoctor(Long id){
        return doctorRepository.findOne(id);
    }
    public List<Doctor>findDoctors(){
        return doctorRepository.findAll();
    }
}

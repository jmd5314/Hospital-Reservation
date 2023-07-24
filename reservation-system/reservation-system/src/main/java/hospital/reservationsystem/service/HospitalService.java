package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Address;
import hospital.reservationsystem.domain.Department;
import hospital.reservationsystem.domain.Doctor;
import hospital.reservationsystem.domain.Hospital;
import hospital.reservationsystem.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    /**
     *  병원 등록
     */
    @Transactional
    public Long create(){
        Doctor doctor1 = Doctor.createDoctor("김민수");
        Doctor doctor2 = Doctor.createDoctor("이혜영");
        Doctor doctor3 = Doctor.createDoctor("조혜은");
        Doctor doctor4 = Doctor.createDoctor("조혜성");
        Doctor doctor5 = Doctor.createDoctor("김용찬");
        Doctor doctor6 = Doctor.createDoctor("이혜진");
        Doctor doctor7 = Doctor.createDoctor("조인경");
        Doctor doctor8 = Doctor.createDoctor("조희진");


        Department department1 = Department.createDepartment("비뇨의학과","0310349043",doctor1);
        department1.addDoctor(doctor2);
        department1.addDoctor(doctor3);
        Department department2 = Department.createDepartment("이비인후과","022745314",doctor4);
        department2.addDoctor(doctor5);
        department2.addDoctor(doctor6);
        Department department3 = Department.createDepartment("정형외과", "0322845834", doctor7);
        department3.addDoctor(doctor8);
        Address address = new Address("서울시","마포구","123-567");
        Hospital hospital = Hospital.createHospital("홍익대학병원", address, department1);
        hospital.addDepartment(department2);
        hospital.addDepartment(department3);
        hospitalRepository.save(hospital);
        return hospital.getId();
    }
    /**
     *  병원 조회
     */
    public Hospital findHospital(Long id){
        return hospitalRepository.findOne(id);
    }
    public List<Hospital> findHospitals(){
        return hospitalRepository.findAll();
    }


}

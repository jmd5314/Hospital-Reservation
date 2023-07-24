package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.*;
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
class HospitalServiceTest {
    @Autowired HospitalService hospitalService;

    public Hospital create(){
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
        return hospital;
    }
}
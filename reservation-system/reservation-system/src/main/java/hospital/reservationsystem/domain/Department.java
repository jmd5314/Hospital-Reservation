package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {
    @Id @Column(name = "department_name")
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    //==연관 관계 메서드==//
    public void addDoctor(Doctor doctor){
        doctors.add(doctor);
        doctor.setDepartment(this);
    }
    // == 생성 메서드 ==//
    public static Department createDepartment(String name, String phoneNumber, Doctor doctor){
        Department department = new Department();
        department.setName(name);
        department.setPhoneNumber(phoneNumber);
        department.addDoctor(doctor);
        return department;
    }
}

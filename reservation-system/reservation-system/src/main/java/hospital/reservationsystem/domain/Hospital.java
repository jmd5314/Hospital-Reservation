package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hospital {
    @Id @GeneratedValue
    @Column(name = "hospital_id")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
    private List<Department> departments = new ArrayList<>();


    //==연관 관계 메서드 ==//
    public void addDepartment(Department department){
        departments.add(department);
        department.setHospital(this);
    }

    //==생성 메서드 ==//
    public static Hospital createHospital(String name, Address address, Department department){
        Hospital hospital = new Hospital();
        hospital.setName(name);
        hospital.setAddress(address);
        hospital.addDepartment(department);
        return hospital;
    }
}

package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Doctor {
    @Id @GeneratedValue
    @Column(name = "doctor_id")
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_name")
    private Department department;
    @OneToMany(mappedBy = "doctor")
    private List<Reserve>reserves = new ArrayList<>();

    // == 생성 메서드 ==//
    public static Doctor createDoctor(String name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        return doctor;
    }
}

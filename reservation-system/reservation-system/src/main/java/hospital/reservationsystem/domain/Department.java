package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Department {
    @Id @Column(name = "department_name")
    private String name;
    private String phoneNumber;
    @OneToMany(mappedBy = "department")
    private List<Doctor> doctors = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}

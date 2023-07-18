package hospital.reservationsystem.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
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
    @OneToMany(mappedBy = "doctor")
    private List<Treatment>treatments = new ArrayList<>();
}

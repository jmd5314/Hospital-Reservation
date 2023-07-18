package hospital.reservationsystem.repository;

import hospital.reservationsystem.domain.Patient;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PatientRepository {
    private final EntityManager em;
    public void save(Patient patient){
        em.persist(patient);
    }
    public Patient findOne(Long id){
        return em.find(Patient.class,id);
    }
    public List<Patient>findAll(){
        return em.createQuery("select p from Patient p",Patient.class).getResultList();
    }
}

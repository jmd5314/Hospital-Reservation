package hospital.reservationsystem.repository;

import hospital.reservationsystem.domain.Doctor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoctorRepository {
    private final EntityManager em;
    public void save(Doctor doctor){
        em.persist(doctor);
    }
    public Doctor findOne(Long id)
    {
        return em.find(Doctor.class, id);
    }
    public List<Doctor> findAll(){
        return em.createQuery("select dt from Doctor dt",Doctor.class).getResultList();
    }
}

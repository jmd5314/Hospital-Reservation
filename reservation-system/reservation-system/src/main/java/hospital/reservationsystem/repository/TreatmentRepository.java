package hospital.reservationsystem.repository;
import hospital.reservationsystem.domain.Reserve;
import hospital.reservationsystem.domain.Treatment;
import hospital.reservationsystem.domain.TreatmentStatus;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TreatmentRepository {
    private final EntityManager em;
    public void save(Treatment treatment){
        em.persist(treatment);
    }
    public Treatment findOne(Long id){
        return em.find(Treatment.class,id);
    }
    public List<Treatment> findAll(){
        return em.createQuery("select t from Treatment t",Treatment.class).getResultList();
    }
}

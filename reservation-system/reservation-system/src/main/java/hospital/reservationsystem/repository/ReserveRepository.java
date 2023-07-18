package hospital.reservationsystem.repository;

import hospital.reservationsystem.domain.Reserve;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReserveRepository {
    private final EntityManager em;
    public void save(Reserve reserve){
        em.persist(reserve);
    }
    public Reserve findOne(Long id){
        return em.find(Reserve.class,id);
    }
    public List<Reserve>findAll(){
        return em.createQuery("select r from Reserve r",Reserve.class).getResultList();
    }
}

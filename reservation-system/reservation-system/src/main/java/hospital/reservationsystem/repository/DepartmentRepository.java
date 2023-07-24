package hospital.reservationsystem.repository;

import hospital.reservationsystem.domain.Department;
import hospital.reservationsystem.domain.Doctor;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepository {
    private final EntityManager em;
    public void save(Department department){
        em.persist(department);
    }
    public Department findOne(String name)
    {
        return em.find(Department.class, name);
    }
    public List<Department> findAll(){
        return em.createQuery("select dp from Department dp", Department.class).getResultList();
    }
}

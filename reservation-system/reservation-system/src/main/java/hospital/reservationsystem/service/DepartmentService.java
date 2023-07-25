package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Department;
import hospital.reservationsystem.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public String save(Department department){
        departmentRepository.save(department);
        return department.getName();
    }
    public Department findDepartment(String name){
        return departmentRepository.findOne(name);
    }
    public List<Department>findDepartments(){
        return departmentRepository.findAll();
    }
}

package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Reserve;
import hospital.reservationsystem.domain.Treatment;
import hospital.reservationsystem.repository.ReserveRepository;
import hospital.reservationsystem.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;
    /**
     * 진료 등록
     */
    @Transactional
    public Long save(Treatment treatment){
        treatmentRepository.save(treatment);
        return treatment.getId();
    }
    /**
     * 진료 조회
     */
    public Treatment findTreatment(Long id){
        return treatmentRepository.findOne(id);
    }
    public List<Treatment> findTreatments(){
        return treatmentRepository.findAll();
    }
}

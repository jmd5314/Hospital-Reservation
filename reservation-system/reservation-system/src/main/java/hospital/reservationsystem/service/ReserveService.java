package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.Reserve;
import hospital.reservationsystem.repository.ReserveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReserveService {
    private final ReserveRepository reserveRepository;

    /**
     * 에약 등록
     */
    @Transactional
    public Long save(Reserve reserve){
        reserveRepository.save(reserve);
        return reserve.getId();
    }
    /**
     * 예약 조회
     */
    public Reserve findReserve(Long id){
        return reserveRepository.findOne(id);
    }
    public List<Reserve>findReserves(){
        return reserveRepository.findAll();
    }
}

package hospital.reservationsystem.controller;
import hospital.reservationsystem.domain.*;
import hospital.reservationsystem.service.HospitalService;
import hospital.reservationsystem.service.ReserveService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReserveController {
    private final HospitalService hospitalService;
    private final ReserveService reserveService;

    @PostConstruct
    public void init(){
        hospitalService.create();
    }
    @PreDestroy
    public void end(){
        hospitalService.close();
    }
    @GetMapping("/reserves/new")
    public String list(Model model){
        List<Hospital> hospitals = hospitalService.findHospitals();
        model.addAttribute("hospitals",hospitals);
        return"/reserves/reserveList";
    }
}

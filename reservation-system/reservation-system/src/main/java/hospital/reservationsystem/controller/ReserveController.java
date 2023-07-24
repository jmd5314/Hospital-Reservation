package hospital.reservationsystem.controller;

import hospital.reservationsystem.domain.*;
import hospital.reservationsystem.service.HospitalService;
import hospital.reservationsystem.service.ReserveService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReserveController {
    private final HospitalService hospitalService;
    private final ReserveService reserveService;

    @GetMapping("/reverses/new")
    public String list(Model model){
        hospitalService.create();
        List<Hospital> hospitals = hospitalService.findHospitals();
        model.addAttribute("hospitals",hospitals);
        return"/reverses/reverseList";
    }
}

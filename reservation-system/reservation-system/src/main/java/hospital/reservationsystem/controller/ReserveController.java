package hospital.reservationsystem.controller;
import hospital.reservationsystem.domain.*;
import hospital.reservationsystem.service.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReserveController {
    private final HospitalService hospitalService;
    private final DoctorService doctorService;
    private final DepartmentService departmentService;
    private final ReserveService reserveService;
    private final PatientService patientService;

    @PostConstruct
    public void init(){
        hospitalService.create();
    }
    @PreDestroy
    public void end(){
        hospitalService.close();
    }
    @GetMapping("/reserves/new")
    public String listHospitals(Model model){
        List<Hospital> hospitals = hospitalService.findHospitals();
        model.addAttribute("hospitals",hospitals);
        return"reserves/reserveList";
    }
    @GetMapping ("/reserves/{doctorId}/create")
    public String createReserve(@PathVariable("doctorId") Long doctorId,Model model){
        ReserveForm reserveForm = new ReserveForm();
        List<Patient> patients = patientService.findPatients();
        model.addAttribute("reserveForm",reserveForm);
        model.addAttribute("patients",patients);
        model.addAttribute("doctorId",doctorId);
        return "reserves/createReserveForm";
    }
    @PostMapping("/reserves/create")
    public String updateReserve(@ModelAttribute("reserveForm") ReserveForm form) {
        Reserve reserve = new Reserve();
        reserve.setPatient(patientService.findPatient(form.getPatientId()));
        reserve.setDate(form.getDate());
        reserve.setStatus(ReserveStatus.RESERVE);
        reserve.setDoctor(doctorService.findDoctor(form.getDoctorId()));
        reserveService.save(reserve);
        return "redirect:/reserves";
    }
    @GetMapping("/reserves")
    public String listReserve(Model model){
        List<Reserve> reserves = reserveService.findReserves();
        model.addAttribute("reserves",reserves);
        return "reserves/List";
    }
}

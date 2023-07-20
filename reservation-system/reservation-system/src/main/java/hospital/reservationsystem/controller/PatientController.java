package hospital.reservationsystem.controller;

import hospital.reservationsystem.domain.Patient;
import hospital.reservationsystem.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    @GetMapping("/patients/new")
    public String createPatient(Model model){
        model.addAttribute("patientForm",new PatientForm());
        return "patients/createPatientForm";
    }
    @PostMapping("/patients/new")
    public String create(@Valid PatientForm form, BindingResult result){
        if(result.hasErrors())
            return "patients/createPatientForm";
        Patient patient = new Patient();
        patient.setName(form.getName());
        patient.setAge(form.getAge());
        patient.setGender(form.getGender());
        patientService.join(patient);
        return "redirect:/";
    }
    @GetMapping("/patients")
    public String list(Model model){
        List<Patient> patients = patientService.findPatients();
        model.addAttribute("patients",patients);
        return "/patients/patientsList";
    }

}

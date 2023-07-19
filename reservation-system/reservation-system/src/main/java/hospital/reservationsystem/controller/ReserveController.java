package hospital.reservationsystem.controller;

import hospital.reservationsystem.service.ReserveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ReserveController {
    private final ReserveService reserveService;


}

package hospital.reservationsystem;

import hospital.reservationsystem.domain.Hospital;
import hospital.reservationsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationSystemApplication {
	public static void main(String[] args) {SpringApplication.run(ReservationSystemApplication.class, args);
	}

}

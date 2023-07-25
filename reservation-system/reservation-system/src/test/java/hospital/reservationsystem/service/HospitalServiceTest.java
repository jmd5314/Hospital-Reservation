package hospital.reservationsystem.service;

import hospital.reservationsystem.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class HospitalServiceTest {
    @Autowired HospitalService hospitalService;
  @Test
  @Rollback(value = false)
  public void 검증() throws Exception{
      //given
      hospitalService.create();
      //when

      //then
   }
}

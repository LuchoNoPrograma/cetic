package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uap.fit.cetic.model.service.IReservaService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {
  private final IReservaService reservaService;

  @GetMapping("/agendar")
  public String agendar(){
    return "vista-reserva/reserva-agenda";
  }
}

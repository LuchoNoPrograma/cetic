package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uap.fit.cetic.model.service.IServicioService;
import uap.fit.cetic.model.service.ISolicitudService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/solicitud")
public class SolicitudController {
  private final ISolicitudService solicitudService;
  private final IServicioService servicioService;

  @GetMapping("/form-registrar")
  public String solicitar(Model model) {
    model.addAttribute("listaServicio", servicioService.listarTodos());
    return "vista-solicitud/solicitud-form";
  }
}

package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uap.fit.cetic.model.dao.ITipoServicioDao;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.service.IServicioService;
import uap.fit.cetic.model.service.ISolicitudService;
import uap.fit.cetic.model.service.ITipoServicioService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/solicitud")
public class SolicitudController {
  private final ISolicitudService solicitudService;
  private final IServicioService servicioService;
  private final ITipoServicioService tipoServicioService;

  @GetMapping("/form-registrar")
  public String solicitar(Model model) {
    model.addAttribute("listaTipoServicio", tipoServicioService.listarTodos());
    return "vista-solicitud/solicitud-form";
  }

  //PostMapping es para registrar o actualizar
  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Solicitud solicitud) {
    solicitudService.guardar(solicitud);
    return "redirect:/solicitud/lista";
  }

  @GetMapping("/lista")
  public String lista(Model model) {
    model.addAttribute("listaSolicitud", solicitudService.listarTodos());
    return "vista-solicitud/solicitud-lista";
  }
}

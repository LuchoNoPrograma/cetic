package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uap.fit.cetic.model.dao.ITipoServicioDao;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.entity.Motivo;
import uap.fit.cetic.model.entity.Reserva;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.enums.EstadoReserva;
import uap.fit.cetic.model.enums.EstadoSolicitud;
import uap.fit.cetic.model.enums.TipoSolicitud;
import uap.fit.cetic.model.service.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/solicitud")
public class SolicitudController {
  private final ISolicitudService solicitudService;
  private final IServicioService servicioService;
  private final ITipoServicioService tipoServicioService;
  private final IMotivoService motivoService;
  private final IReservaService reservaService;

  @GetMapping("/form-registrar")
  public String solicitar(Model model) {
    model.addAttribute("solicitud", new Solicitud());
    model.addAttribute("listaTipoServicio", tipoServicioService.listarTodos());
    return "vista-solicitud/solicitud-form";
  }

  //PostMapping es para registrar o actualizar
  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Solicitud solicitud, @RequestParam(required = false) String motivoReserva,
                          @RequestParam(required = false) List<Long> motivosSeleccionados) {
    solicitud.setFechaSolicitud(LocalDateTime.now());
    solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);
    if(solicitud.getTipoSolicitud() == TipoSolicitud.RESERVA_DE_LABORATORIO){
      Reserva reserva = new Reserva();
      reserva.setMotivo(motivoReserva);
      reserva.setEstadoReserva(EstadoReserva.PENDIENTE);
      reserva.setSolicitud(solicitud);
      reservaService.guardar(reserva);
    }else {
      Set<Motivo> listaMotivos = motivoService.buscarTodosPorIds(motivosSeleccionados);
      solicitud.setListaSolicitudMotivo(listaMotivos);
      solicitudService.guardar(solicitud);
    }
    return "redirect:/solicitud/lista";
  }

  @GetMapping("/lista")
  public String lista(Model model) {
    model.addAttribute("listaSolicitud", solicitudService.listarTodos());
    return "vista-solicitud/solicitud-lista";
  }

  @ResponseBody
  @DeleteMapping("/rechazar/{idSolicitud}")
  public ResponseEntity<String> eliminar(@PathVariable Long idSolicitud) {
    Solicitud solicitud = solicitudService.buscarPorId(idSolicitud);
    solicitud.setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
    solicitudService.guardar(solicitud);
    return ResponseEntity.ok("Solicitud rechazada correctamente, N° de Solicitud: "+ solicitud.getNroSolicitud());
  }
}

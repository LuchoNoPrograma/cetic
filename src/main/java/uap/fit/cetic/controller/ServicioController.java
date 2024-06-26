package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uap.fit.cetic.dto.MotivoDto;
import uap.fit.cetic.dto.ReporteDto;
import uap.fit.cetic.dto.TipoServicioDto;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.enums.EstadoServicio;
import uap.fit.cetic.model.service.IReporteService;
import uap.fit.cetic.model.service.IServicioService;
import uap.fit.cetic.model.service.ISolicitudService;
import uap.fit.cetic.model.service.ITipoServicioService;
import uap.fit.cetic.util.ResponseEntityUtil;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/servicio")
public class ServicioController {
  private final ModelMapper modelMapper;
  private final IServicioService servicioService;
  private final ISolicitudService solicitudService;
  private final ITipoServicioService tipoServicioService;
  private final IReporteService reporteService;

  @GetMapping("/lista")
  public String lista(Model model) {
    model.addAttribute("listaServicio", servicioService.listarTodosSolicitudAceptada());
    model.addAttribute("nPendientes", servicioService.contarPorEstadoServicio(EstadoServicio.PENDIENTE));
    model.addAttribute("nFinalizados", servicioService.contarPorEstadoServicio(EstadoServicio.FINALIZADO));
    return "vista-servicio/servicio-lista";

  }

  @GetMapping("/solicitud/{nroSolicitud}/form-registrar")
  public String formRegistro(Model model, @PathVariable Long nroSolicitud) {
    model.addAttribute("solicitud", solicitudService.buscarPorId(nroSolicitud));
    return "servicio-atender";
  }

  @GetMapping("/solicitud/{nroSolicitud}/atender")
  public String atenderSolicitud(Model model, @PathVariable Long nroSolicitud) {
    model.addAttribute("solicitud", solicitudService.buscarPorId(nroSolicitud));
    return "vista-servicio/servicio-atender";
  }

  @GetMapping("/solicitud/{nroSolicitud}/seguimiento-servicio")
  public String seguimientoSolicitudConServicios(Model model, @PathVariable Long nroSolicitud) {
    model.addAttribute("solicitud", solicitudService.buscarPorId(nroSolicitud));
    return "vista-servicio/servicio-seguimiento";
  }

  @ResponseBody
  @GetMapping("/tipo-servicio")
  public ResponseEntity<List<TipoServicioDto>> listaTipoServicio() {
    return ResponseEntity.ok(tipoServicioService.listarTodos().stream().map(t -> TipoServicioDto.builder()
        .idTipoServicio(t.getIdTipoServicio())
        .nombre(t.getNombre())
        .descripcion(t.getDescripcion())
        .listaMotivo(t.getListaMotivo().stream().map(m -> MotivoDto.builder()
          .idMotivo(m.getIdMotivo())
          .nombre(m.getNombre())
          .descripcion(m.getDescripcion())
          .build()
        ).toList())
        .build()
      ).toList()
    );
  }
}

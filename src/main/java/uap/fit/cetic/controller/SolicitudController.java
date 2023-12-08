package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uap.fit.cetic.dto.*;
import uap.fit.cetic.model.entity.Reserva;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.enums.EstadoReserva;
import uap.fit.cetic.model.enums.EstadoSolicitud;
import uap.fit.cetic.model.enums.TipoSolicitud;
import uap.fit.cetic.model.service.*;
import uap.fit.cetic.util.ResponseEntityUtil;

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
  private final ModelMapper modelMapper;
  private final IReporteService reporteService;

  @GetMapping("/form-registrar")
  public String solicitar(Model model) {
    model.addAttribute("solicitud", new Solicitud());
    model.addAttribute("listaTipoServicio", tipoServicioService.listarTodos());
    return "vista-solicitud/solicitud-form";
  }

  //PostMapping es para registrar o actualizar
  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Solicitud solicitud, @RequestParam(required = false) String motivoReserva) {
    solicitud.setFechaSolicitud(LocalDateTime.now());
    solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);
    if (solicitud.getTipoSolicitud() == TipoSolicitud.RESERVA_DE_LABORATORIO) {
      Reserva reserva = new Reserva();
      reserva.setMotivo(motivoReserva);
      reserva.setEstadoReserva(EstadoReserva.PENDIENTE);
      reserva.setSolicitud(solicitud);
      reservaService.guardar(reserva);
    } else {
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
  @PostMapping("/api/v1/registrar")
  public ResponseEntity<?> registrarRest(@RequestBody SolicitudDto solicitudDto) {
    Solicitud solicitud = solicitudService.guardarDto(solicitudDto);
    return ResponseEntity.ok(modelMapper.map(solicitud, SolicitudDto.class));
  }

  @ResponseBody
  @PutMapping("/api/v1/aceptar-servicio-tecnico")
  public ResponseEntity<?> aceptarSolicitudTecnica(@RequestBody SolicitudDto solicitudDto) {
    Solicitud solicitud = solicitudService.aceptarSolicitudTecnica(solicitudDto);
    return ResponseEntity.ok(modelMapper.map(solicitud, SolicitudDto.class));
  }

  @ResponseBody
  @GetMapping("/api/v1/{nroSolicitud}/servicio-tecnico")
  public ResponseEntity<?> findSolicitudByNroSolicitud(@PathVariable Long nroSolicitud) {
    Solicitud solicitud = solicitudService.buscarPorId(nroSolicitud);
    SolicitudDto solicitudDto = modelMapper.map(solicitud, SolicitudDto.class);

    solicitudDto.setCliente(modelMapper.map(solicitud.getCliente(), ClienteDto.class));
    solicitudDto.setListaServicio(solicitud.getListaServicio().stream().map(servicio -> {
      ServicioDto servicioDto = modelMapper.map(servicio, ServicioDto.class);
      EquipoDto equipoDto = modelMapper.map(servicio.getEquipo(), EquipoDto.class);
      List<MotivoDto> listaMotivoDto = servicio.getListaMotivo().stream().map(motivo -> modelMapper.map(motivo, MotivoDto.class)).toList();
      List<DetalleServicioDto> listaDetalleServicioDto = servicio.getListaDetalleServicio().stream().map(ds -> modelMapper.map(ds, DetalleServicioDto.class)).toList();
      List<AsignacionDto> listaAsignacionDto = servicio.getListaAsignacion().stream().map(a -> {
        AsignacionDto asignacionDto = modelMapper.map(a, AsignacionDto.class);
        asignacionDto.setTecnico(modelMapper.map(a.getTecnico(), TecnicoDto.class));

        return asignacionDto;
      }).toList();

      servicioDto.setListaAsignacion(listaAsignacionDto);
      servicioDto.setEquipo(equipoDto);
      servicioDto.setListaDetalleServicio(listaDetalleServicioDto);
      servicioDto.setListaMotivo(Set.copyOf(listaMotivoDto));

      return servicioDto;
    }).toList());

    return ResponseEntity.ok(solicitudDto);
  }

  @ResponseBody
  @PostMapping("/api/v1/finalizar-solicitud-servicio")
  public ResponseEntity<?> finalizarSolicitudServicio(@RequestBody SolicitudDto solicitudDto) {
    Solicitud solicitud = solicitudService.finalizarSolicitudServicio(solicitudDto);
    return ResponseEntity.ok(modelMapper.map(solicitud, SolicitudDto.class));
  }

  @ResponseBody
  @DeleteMapping("/rechazar/{idSolicitud}")
  public ResponseEntity<String> eliminar(@PathVariable Long idSolicitud) {
    Solicitud solicitud = solicitudService.buscarPorId(idSolicitud);
    solicitud.setEstadoSolicitud(EstadoSolicitud.RECHAZADA);
    solicitudService.guardar(solicitud);
    return ResponseEntity.ok("Solicitud rechazada correctamente, N° de Solicitud: " + solicitud.getNroSolicitud());
  }

  @ResponseBody
  @GetMapping(value = "/api/v1/informe-servicio-equipo/{nroSolicitud}", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity<?> reporteInformeServiciosEquipos(@PathVariable Long nroSolicitud) {
    Solicitud solicitud = solicitudService.buscarPorId(nroSolicitud);
    ReporteDto reporteDto = reporteService.reporteInformeServiciosEquipos(solicitud);
    return ResponseEntityUtil.getResponseEntityPdf(reporteDto);
  }
}

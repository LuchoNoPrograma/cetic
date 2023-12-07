package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uap.fit.cetic.dto.EventoCalendarioDto;
import uap.fit.cetic.model.entity.Reserva;
import uap.fit.cetic.model.service.IReservaService;
import uap.fit.cetic.model.service.ISolicitudService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {
  private final IReservaService reservaService;
  private final ISolicitudService solicitudService;

  @GetMapping("/solicitud/{nroSolicitud}/agendar")
  public String agendar(@PathVariable Long nroSolicitud, Model model) {
    model.addAttribute("solicitud", solicitudService.buscarPorId(nroSolicitud));
    model.addAttribute("listaReserva", reservaService.listarPorNroSolicitud(nroSolicitud));
    return "vista-reserva/reserva-agenda";
  }

  @ResponseBody
  @GetMapping("/lista-eventos-calendario")
  public ResponseEntity<List<EventoCalendarioDto>> listaReservas() {
    List<Reserva> listaReserva = reservaService.listarTodos();
    List<EventoCalendarioDto> listaEventosCalendario = new ArrayList<>();
    listaReserva.forEach(reserva -> {
      reserva.getListaDetalleReserva().size();
      reserva.getListaDetalleReserva().forEach(detalleReserva -> {
        EventoCalendarioDto dto = new EventoCalendarioDto();
        dto.setId(detalleReserva.getIdDetalleReserva());
        dto.setTitle(detalleReserva.getReserva().getMotivo());
        dto.setStart(detalleReserva.getHoraInicio());
        dto.setEnd(detalleReserva.getHoraFin());
        listaEventosCalendario.add(dto);
      });
    });

    return ResponseEntity.ok(listaEventosCalendario);
  }
}

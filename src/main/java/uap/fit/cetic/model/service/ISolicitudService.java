package uap.fit.cetic.model.service;

import uap.fit.cetic.dto.SolicitudDto;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.enums.EstadoSolicitud;

public interface ISolicitudService extends IServiceGenerico<Solicitud, Long> {
  Solicitud guardarDto(SolicitudDto solicitudDto);

  Solicitud aceptarSolicitudTecnica(SolicitudDto solicitudDto);

  Solicitud finalizarSolicitudServicio(SolicitudDto solicitudDto);

  Solicitud guardarSeguimientoSolicitud(SolicitudDto solicitudDto);

  Long contarByEstadoSolicitud(EstadoSolicitud estadoSolicitud);
}

package uap.fit.cetic.model.service;

import uap.fit.cetic.dto.SolicitudDto;
import uap.fit.cetic.model.entity.Solicitud;

public interface ISolicitudService extends IServiceGenerico<Solicitud, Long> {
  Solicitud guardarDto(SolicitudDto solicitudDto);

  Solicitud aceptarSolicitudTecnica(SolicitudDto solicitudDto);
}

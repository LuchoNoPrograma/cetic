package uap.fit.cetic.model.service;

import uap.fit.cetic.dto.ReporteDto;
import uap.fit.cetic.model.entity.Solicitud;

public interface IReporteService {
  ReporteDto reporteInformeServiciosEquipos(Solicitud solicitud);

  ReporteDto reporteSolicitudServicio(Solicitud solicitud);
}

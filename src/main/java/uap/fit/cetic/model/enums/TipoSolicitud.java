package uap.fit.cetic.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoSolicitud {
  SERVICIO_TECNICO("Servicio técnico"),
  RESERVA_DE_LABORATORIO("Reserva de laboratorio");
  private final String nombreFormal;
}

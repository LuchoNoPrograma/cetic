package uap.fit.cetic.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoLaboratorio {
  DISPONIBLE("Disponible"),
  RESERVADO("Reservado"),
  EN_USO("En uso");
  private final String nombreFormal;
}

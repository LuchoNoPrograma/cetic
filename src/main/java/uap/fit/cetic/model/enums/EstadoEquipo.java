package uap.fit.cetic.model.enums;

import lombok.Getter;

@Getter
public enum EstadoEquipo {
  DISPONIBLE("Disponible"),
  EN_USO("En uso"),
  EN_MANTENIMIENTO("En mantenimiento"),
  DE_BAJA("De baja"),
  ELIMINADO("Eliminado");
  private final String nombreFormal;

  EstadoEquipo(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }
}

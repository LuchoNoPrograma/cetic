package uap.fit.cetic.model.enums;

import lombok.Getter;

@Getter
public enum EstadoEquipo {
  ACTIVO("Activo"),
  INACTIVO("Inactivo"),
  ELIMINADO("Eliminado");
  private final String nombreFormal;

  EstadoEquipo(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }
}

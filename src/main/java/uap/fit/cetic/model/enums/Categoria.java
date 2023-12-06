package uap.fit.cetic.model.enums;

import lombok.Getter;

@Getter
public enum Categoria {
  PC_ESCRITORIO("PC Escritorio"),
  IMPRESORA("Impresora"),
  PROYECTOR("Proyector"),
  MONITOR("Monitor"),
  LAPTOP("Laptop"),
  PC_TODO_EN_UNO("PC todo en uno"),
  UPS("UPS");
  private final String nombreFormal;

  Categoria(String nombreFormal) {
    this.nombreFormal = nombreFormal;
  }
}

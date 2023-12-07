package uap.fit.cetic.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum Categoria {
  PC_ESCRITORIO("PC Escritorio","mdi-desktop"),
  IMPRESORA("Impresora", "mdi-printer"),
  PROYECTOR("Proyector", "mdi-television"),
  MONITOR("Monitor", "mdi-monitor"),
  LAPTOP("Laptop", "mdi-laptop"),
  PC_TODO_EN_UNO("PC todo en uno", "mdi-desktop"),
  UPS("UPS", "mdi-power");
  private final String nombreFormal;
  private final String icono;
}

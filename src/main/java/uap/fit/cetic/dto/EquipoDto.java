package uap.fit.cetic.dto;

import lombok.*;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.enums.Categoria;

import java.io.Serializable;

/**
 * DTO for {@link Equipo}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipoDto implements Serializable {
  private Long idEquipo;
  private String codUap;
  private String codSerie;
  private String marca;
  private String modelo;
  private Categoria categoria;
  private String color;
}
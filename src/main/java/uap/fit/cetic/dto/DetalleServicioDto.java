package uap.fit.cetic.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link uap.fit.cetic.model.entity.DetalleServicio}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleServicioDto implements Serializable {
  private Long idDetalleServicio;
  private Float costo;
  private String descripcion;
}
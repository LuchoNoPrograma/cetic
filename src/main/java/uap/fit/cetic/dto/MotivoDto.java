package uap.fit.cetic.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Motivo}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotivoDto implements Serializable {
  private Long idMotivo;
  private String nombre;
  private String descripcion;
}
package uap.fit.cetic.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Asignacion}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsignacionDto implements Serializable {
  private LocalDateTime fechaAsignacion;
}
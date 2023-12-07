package uap.fit.cetic.dto;

import lombok.*;
import uap.fit.cetic.model.enums.EstadoReserva;

import java.io.Serializable;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Reserva}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDto implements Serializable {
  private String motivo;
  private String nombreActividad;
  private EstadoReserva estadoReserva;
}
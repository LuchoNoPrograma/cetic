package uap.fit.cetic.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * DTO que se utiliza para la vista reserva-agenda.html
 * DTO for {@link uap.fit.cetic.model.entity.DetalleReserva}
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoCalendarioDto {
  private Long id;
  private String title;
  private LocalDateTime start;
  private LocalDateTime end;
}

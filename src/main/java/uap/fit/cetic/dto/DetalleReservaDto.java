package uap.fit.cetic.dto;

import lombok.*;
import uap.fit.cetic.model.enums.EstadoReserva;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * DTO for {@link uap.fit.cetic.model.entity.DetalleReserva}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleReservaDto implements Serializable {
    private String reservaNombreActividad;
    private LocalDate fechaUso;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Long laboratorioIdLaboratorio;
    private Long reservaIdReserva;
    private EstadoReserva estadoReserva;
}
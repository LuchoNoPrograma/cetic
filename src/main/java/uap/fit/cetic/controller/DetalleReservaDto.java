package uap.fit.cetic.controller;

import lombok.*;
import uap.fit.cetic.dto.ReservaDto;
import uap.fit.cetic.model.entity.Laboratorio;
import uap.fit.cetic.model.entity.LaboratorioDto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uap.fit.cetic.model.entity.DetalleReserva}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleReservaDto implements Serializable {
    private LaboratorioDto laboratorio;
    private ReservaDto reserva;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private String observacion;
}
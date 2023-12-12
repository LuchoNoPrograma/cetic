package uap.fit.cetic.model.entity;

import lombok.*;
import uap.fit.cetic.model.enums.EstadoLaboratorio;

import java.io.Serializable;

/**
 * DTO for {@link Laboratorio}
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaboratorioDto implements Serializable {
    private Long idLaboratorio;
    private String nombre;
    private String horario;
    private EstadoLaboratorio estado;
}
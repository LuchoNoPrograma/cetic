package uap.fit.cetic.dto;

import lombok.*;
import uap.fit.cetic.model.enums.TipoSolicitud;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Solicitud}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitudDto implements Serializable {
  private List<ServicioDto> listaServicio;

  private ReservaDto reserva;
  private ClienteDto cliente;
  private TecnicoDto tecnico;

  private Long nroSolicitud;
  private LocalDateTime fechaSolicitud;
  private String observacion;
  private String descripcion;
  private TipoSolicitud tipoSolicitud;
}
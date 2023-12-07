package uap.fit.cetic.dto;

import lombok.*;
import uap.fit.cetic.model.entity.Asignacion;
import uap.fit.cetic.model.entity.Servicio;
import uap.fit.cetic.model.enums.EstadoServicio;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * DTO for {@link Servicio}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicioDto implements Serializable {
  private Set<MotivoDto> listaMotivo;
  private List<TecnicoDto> listaTecnico;
  private List<AsignacionDto> listaAsignacion;
  private List<DetalleServicioDto> listaDetalleServicio;
  private EquipoDto equipo;
  private Long idServicio;
  private Float costoTotal;
  private String diagnostico;
  private String observacion;
  private EstadoServicio estadoServicio;
}
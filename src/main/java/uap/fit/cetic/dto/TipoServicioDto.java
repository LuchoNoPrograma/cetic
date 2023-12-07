package uap.fit.cetic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link uap.fit.cetic.model.entity.TipoServicio}
 */
@Getter
@Setter
@Builder
public class TipoServicioDto implements Serializable {
  /**
  * DTO for {@link uap.fit.cetic.model.entity.Motivo}>
  * */
  private List<MotivoDto> listaMotivo;
  private Long idTipoServicio;
  private String nombre;
  private String descripcion;
}
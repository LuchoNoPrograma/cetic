package uap.fit.cetic.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Tecnico}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TecnicoDto implements Serializable {
  private Long idTecnico;

  private String nombre;
  private String apellidos;
  private String ci;
  private String celular;
}
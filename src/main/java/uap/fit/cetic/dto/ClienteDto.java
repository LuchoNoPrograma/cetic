package uap.fit.cetic.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link uap.fit.cetic.model.entity.Cliente}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto implements Serializable {
  private String nombre;
  private String apellidos;
  private String ci;
  private String celular;
}
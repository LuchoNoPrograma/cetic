package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_servicio")
public class TipoServicio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_tipo_servicio", nullable = false)
  private Long idTipoServicio;

  @Column(name = "nombre", nullable = false, length = 70)
  private String nombre;

  private String descripcion;
}

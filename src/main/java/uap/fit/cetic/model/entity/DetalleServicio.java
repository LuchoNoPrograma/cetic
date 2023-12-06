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
@Table(name = "detalle_servicio")
public class DetalleServicio {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_servicio")
  private Servicio servicio;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_detalle_servicio", nullable = false)
  private Long idDetalleServicio;

  @Column(name = "costo", nullable = false)
  private Float costo;

  @Column(name = "descripcion", length = 155)
  private String descripcion;
}

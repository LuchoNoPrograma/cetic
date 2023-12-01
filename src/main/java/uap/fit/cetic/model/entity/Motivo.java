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
@Table(name = "motivo")
public class Motivo {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_servicio", referencedColumnName = "id_servicio", nullable = false)
  private Servicio servicio;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_motivo", nullable = false)
  private Long idMotivo;

  @Column(name = "nombre", columnDefinition = "TEXT")
  private String nombre;
}

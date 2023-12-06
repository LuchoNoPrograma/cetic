package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "motivo")
public class Motivo implements Serializable {
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tipo_servicio")
  private TipoServicio tipoServicio;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_motivo")
  private Long idMotivo;

  @Column(name = "nombre", length = 55, nullable = false)
  private String nombre;

  @Column(name = "descripcion", length = 155)
  private String descripcion;
}

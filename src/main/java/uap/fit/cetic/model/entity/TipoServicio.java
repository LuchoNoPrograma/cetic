package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipo_servicio")
public class TipoServicio implements Serializable {
  @OneToMany(mappedBy = "tipoServicio", fetch = FetchType.LAZY)
  private List<Motivo> listaMotivo;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_tipo_servicio", nullable = false)
  private Long idTipoServicio;

  @Column(name = "nombre", nullable = false, length = 55)
  private String nombre;

  @Column(name = "descripcion", length = 155)
  private String descripcion;
}

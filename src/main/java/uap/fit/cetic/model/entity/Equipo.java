package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import uap.fit.cetic.model.enums.Categoria;
import uap.fit.cetic.model.enums.EstadoEquipo;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "equipo")
public class Equipo implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_equipo", nullable = false)
  private Long idEquipo;

  @Column(name = "cod_uap", length = 55)
  private String codUap;

  @Column(name = "cod_serie", nullable = false, unique = true, length = 55)
  private String codSerie;

  @Column(name = "color", length = 55)
  private String color;

  @Column(name = "modelo", length = 55)
  private String modelo;

  @Column(name = "marca", length = 55)
  private String marca;

  @Enumerated(EnumType.STRING)
  @Column(name = "estado_equipo", length = 30)
  private EstadoEquipo estadoEquipo;

  @Enumerated(EnumType.STRING)
  @Column(name = "categoria", length = 55)
  private Categoria categoria;
}

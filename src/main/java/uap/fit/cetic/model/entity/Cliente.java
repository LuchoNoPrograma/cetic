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
@Table(name = "cliente")
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_persona", nullable = false)
  private Long idPersona;

  @Column(name = "nombre", nullable = false, length = 30)
  private String nombre;

  @Column(name = "apellidos", nullable = false, length = 75)
  private String apellidos;

  @Column(name = "ci", nullable = false, length = 30)
  private String ci;

  @Column(name = "celular", nullable = false, length = 10)
  private String celular;

  @Column(name = "email", length = 55)
  private String email;
}

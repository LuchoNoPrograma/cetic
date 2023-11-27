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
@Table(name = "persona")
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_persona", nullable = false, unique = true)
  private Long idPersona;

  @Column(name = "nombre", nullable = false, length = 30)
  private String nombre;

  @Column(name = "paterno", nullable = false, length = 30)
  private String paterno;

  @Column(name = "materno", length = 30)
  private String materno;

  @Column(name = "ci", length = 30, nullable = false)
  private String ci;

  @Column(name = "celular", length = 10)
  private String celular;

  @Column(name = "email", length = 55)
  private String email;
}

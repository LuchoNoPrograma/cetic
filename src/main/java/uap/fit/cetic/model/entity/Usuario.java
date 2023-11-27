package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_id_tecnico", referencedColumnName = "id_tecnico")
  private Tecnico tecnico;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "usuario_permiso",
    joinColumns = @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "fk_id_permiso", referencedColumnName = "id_permiso"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"fk_id_usuario", "fk_id_permiso"})}
  )
  private Set<Permiso> listaPermiso;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Long idUsuario;

  @Column(name = "username", nullable = false, unique = true, length = 55)
  private String username;

  @Column(name = "password", nullable = false, length = 55)
  private String password;

  @Column(name = "enabled")
  private Boolean enabled;
}

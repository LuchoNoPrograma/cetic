package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_tecnico")
  private Tecnico tecnico;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "usuario_permiso",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "id_permiso")
  )
  private Set<Permiso> listaPermiso;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
  private List<Menu> listaMenus;

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

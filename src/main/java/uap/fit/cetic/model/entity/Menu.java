package uap.fit.cetic.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class Menu {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_usuario")
  private Usuario usuario;

  @OneToMany(mappedBy = "menu")
  private List<Enlace> listaEnlace;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_menu")
  private Long idMenu;

  @Column(name = "nombre", length = 55)
  private String nombre;

  @Column(name = "ruta", length = 55)
  private String ruta;
}

package uap.fit.cetic.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "permiso")
public class Permiso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_permiso")
  private Long idPermiso;

  @Column(name = "nombre_permiso")
  private String nombrePermiso;
}

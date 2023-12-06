package uap.fit.cetic.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "menu")
public class Menu {

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_usuario")
  private Usuario usuario;

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_menu")
    private Long idMenu;
    
    @Column(name = "nombre",length = 55)
  private String nombre;

  @Column(name = "ruta", length = 55)
  private String ruta;
}

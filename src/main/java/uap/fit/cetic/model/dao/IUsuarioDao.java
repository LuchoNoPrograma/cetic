package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uap.fit.cetic.model.entity.Usuario;

import java.util.Optional;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
  @Query("SELECT u FROM Usuario u WHERE u.username = ?1")
  Optional<Usuario> buscarPorUsername(String username);
}
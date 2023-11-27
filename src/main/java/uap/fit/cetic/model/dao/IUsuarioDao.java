package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
}
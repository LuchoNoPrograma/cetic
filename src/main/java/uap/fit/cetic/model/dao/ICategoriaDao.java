package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.TipoServicio;

public interface ITipoServicioDao extends JpaRepository<TipoServicio, Long> {
}
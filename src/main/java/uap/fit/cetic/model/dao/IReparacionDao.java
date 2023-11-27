package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Reparacion;

public interface IReparacionDao extends JpaRepository<Reparacion, Long> {
}
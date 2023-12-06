package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Asignacion;

public interface IAsignacionDao extends JpaRepository<Asignacion, Long> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Equipo;

public interface IEquipoDao extends JpaRepository<Equipo, Long> {
}
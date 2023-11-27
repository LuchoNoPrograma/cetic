package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Permiso;

public interface IPermisoDao extends JpaRepository<Permiso, Long> {
}
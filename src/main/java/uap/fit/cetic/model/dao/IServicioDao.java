package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Servicio;

public interface IServicioDao extends JpaRepository<Servicio, Long> {
}
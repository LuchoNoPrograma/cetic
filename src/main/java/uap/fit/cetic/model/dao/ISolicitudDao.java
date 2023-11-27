package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long> {
}
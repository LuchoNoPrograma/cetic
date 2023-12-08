package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uap.fit.cetic.model.entity.Solicitud;

import java.util.List;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long> {
  @Query("SELECT s FROM Solicitud s ORDER BY s.fechaSolicitud DESC")
  List<Solicitud> findAllOrderByFechaRegistro();
}
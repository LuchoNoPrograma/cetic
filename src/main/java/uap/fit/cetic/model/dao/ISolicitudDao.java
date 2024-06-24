package uap.fit.cetic.model.dao;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.model.enums.EstadoSolicitud;

import java.util.List;
import java.util.Optional;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long> {
  @Query("SELECT s FROM Solicitud s ORDER BY s.fechaSolicitud DESC")
  List<Solicitud> findAllOrderByFechaRegistro();

  @Query(value = "SELECT count(sol) FROM Solicitud sol WHERE sol.estadoSolicitud = ?1")
  Long contarByEstadoSolicitud(EstadoSolicitud estadoSolicitud);
}
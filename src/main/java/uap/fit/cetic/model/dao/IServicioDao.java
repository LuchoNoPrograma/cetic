package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uap.fit.cetic.model.entity.Servicio;

import java.util.List;

public interface IServicioDao extends JpaRepository<Servicio, Long> {

  @Query("SELECT s FROM Servicio s ORDER BY s.solicitud.nroSolicitud DESC")
  List<Servicio> findAllOrderByNroSolicitudDesc();

  @Query("SELECT ser FROM Servicio ser LEFT JOIN ser.solicitud sol WHERE sol.estadoSolicitud = 'ACEPTADA' ORDER BY ser.solicitud.nroSolicitud DESC")
    List<Servicio> findAllSolicitudAceptada();
}
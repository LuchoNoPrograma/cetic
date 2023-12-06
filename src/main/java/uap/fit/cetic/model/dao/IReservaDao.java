package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uap.fit.cetic.model.entity.Reserva;

import java.util.List;

public interface IReservaDao extends JpaRepository<Reserva, Long> {
  @Query("SELECT r FROM Reserva r WHERE r.solicitud.nroSolicitud = :nroSolicitud")
  List<Reserva> listarPorNroSolicitud(Long nroSolicitud);
}
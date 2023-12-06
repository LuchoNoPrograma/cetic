package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.DetalleReserva;

public interface IDetalleReservaDao extends JpaRepository<DetalleReserva, Long> {
}
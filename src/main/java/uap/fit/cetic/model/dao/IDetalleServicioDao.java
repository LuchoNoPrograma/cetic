package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.DetalleServicio;

public interface IDetalleServicioDao extends JpaRepository<DetalleServicio, Long> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Reserva;

public interface IReservaDao extends JpaRepository<Reserva, Long> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Pago;

public interface IPagoDao extends JpaRepository<Pago, Long> {
}
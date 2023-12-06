package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Traslado;
import uap.fit.cetic.model.entity.TrasladoId;

public interface ITrasladoDao extends JpaRepository<Traslado, TrasladoId> {
}
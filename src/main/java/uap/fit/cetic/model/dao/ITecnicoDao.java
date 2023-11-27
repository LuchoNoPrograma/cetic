package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Tecnico;

public interface ITecnicoDao extends JpaRepository<Tecnico, Long> {
}
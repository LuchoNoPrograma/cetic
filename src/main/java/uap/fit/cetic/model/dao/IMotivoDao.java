package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Motivo;

public interface IMotivoDao extends JpaRepository<Motivo, Long> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Asistencia;

public interface IAsistenciaDao extends JpaRepository<Asistencia, Long> {
}
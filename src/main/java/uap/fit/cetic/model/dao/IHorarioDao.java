package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Horario;

public interface IHorarioDao extends JpaRepository<Horario, Long> {
}
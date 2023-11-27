package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Laboratorio;

public interface ILaboratorioDao extends JpaRepository<Laboratorio, Long> {
}

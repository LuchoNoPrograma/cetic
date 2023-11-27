package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Long> {
}
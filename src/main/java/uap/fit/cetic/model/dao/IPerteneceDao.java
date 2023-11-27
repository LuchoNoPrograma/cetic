package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uap.fit.cetic.model.entity.Pertenece;

public interface IPerteneceDao extends JpaRepository<Pertenece, Long>, JpaSpecificationExecutor<Pertenece> {
}
package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uap.fit.cetic.model.entity.Laboratorio;

import java.util.List;

@Repository
public interface ILaboratorioDao extends JpaRepository<Laboratorio, Long> {

  @Query("SELECT l FROM Laboratorio l " +
    "WHERE l.estado  = 'DISPONIBLE'")
  List<Laboratorio> findAllDisponibles();
}

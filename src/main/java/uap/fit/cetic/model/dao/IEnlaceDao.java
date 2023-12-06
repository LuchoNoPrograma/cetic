package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Enlace;

public interface IEnlaceDao extends JpaRepository<Enlace, Long> {
    
}

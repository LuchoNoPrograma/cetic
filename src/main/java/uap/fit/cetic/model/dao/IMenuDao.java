package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Menu;

public interface IMenuDao extends JpaRepository<Menu, Long>  {
    
}


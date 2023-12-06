package uap.fit.cetic.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import uap.fit.cetic.model.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
}
package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IClienteDao;
import uap.fit.cetic.model.entity.Cliente;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {
  private final IClienteDao clienteDao;

  @Override
  public Cliente buscarPorId(Long id) {
    return clienteDao.findById(id).orElse(null);
  }

  @Override
  public List<Cliente> listarTodos() {
    return clienteDao.findAll();
  }

  @Override
  public Cliente guardar(Cliente entidad) {
    return clienteDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    clienteDao.deleteById(id);
  }
}

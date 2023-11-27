package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IReparacionDao;
import uap.fit.cetic.model.entity.Reparacion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReparacionServiceImpl implements IReparacionService {
  private final IReparacionDao reparacionDao;

  @Override
  public Reparacion buscarPorId(Long id) {
    return reparacionDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
  }

  @Override
  public List<Reparacion> listarTodos() {
    return reparacionDao.findAll(Sort.by("idReparacion").ascending());
  }

  @Override
  public Reparacion guardar(Reparacion entidad) {
    return reparacionDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    reparacionDao.deleteById(id);
  }
}

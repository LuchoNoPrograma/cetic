package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IPermisoDao;
import uap.fit.cetic.model.entity.Permiso;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermisoServiceImpl implements IPermisoService {
  private final IPermisoDao permisoDao;
  @Override
  public Permiso buscarPorId(Long id) {
    return permisoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
  }

  @Override
  public List<Permiso> listarTodos() {
    return permisoDao.findAll(Sort.by("idPermiso").ascending());
  }

  @Override
  public Permiso guardar(Permiso entidad) {
    return permisoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    permisoDao.deleteById(id);
  }
}

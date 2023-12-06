package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IAsignacionDao;
import uap.fit.cetic.model.entity.Asignacion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionServiceImpl implements IAsignacionService {
  private final IAsignacionDao asignacionDao;

  @Override
  public Asignacion buscarPorId(Long id) {
    return asignacionDao.findById(id).orElse(null);
  }

  @Override
  public List<Asignacion> listarTodos() {
    return asignacionDao.findAll(Sort.by("idAsignacion").descending());
  }

  @Override
  public Asignacion guardar(Asignacion entidad) {
    return null;
  }

  @Override
  public void eliminarPorId(Long id) {
    asignacionDao.deleteById(id);
  }
}

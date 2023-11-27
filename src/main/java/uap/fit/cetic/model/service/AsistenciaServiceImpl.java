package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IAsistenciaDao;
import uap.fit.cetic.model.entity.Asistencia;
import uap.fit.cetic.model.entity.Pertenece;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaServiceImpl implements IAsistenciaService {
  private final IAsistenciaDao asistenciaDao;

  @Override
  public Asistencia buscarPorId(Long id) {
    return asistenciaDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: "+id));
  }

  @Override
  public List<Asistencia> listarTodos() {
    return asistenciaDao.findAll(Sort.by("fechaRegistro").descending());
  }

  @Override
  public Asistencia guardar(Asistencia entidad) {
    return asistenciaDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    asistenciaDao.deleteById(id);
  }
}

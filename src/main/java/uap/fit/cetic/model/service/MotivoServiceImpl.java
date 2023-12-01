package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IMotivoDao;
import uap.fit.cetic.model.entity.Motivo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotivoServiceImpl implements IMotivoService {
  private final IMotivoDao motivoDao;

  @Override
  public Motivo buscarPorId(Long id) {
    return motivoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
  }

  @Override
  public List<Motivo> listarTodos() {
    return motivoDao.findAll(Sort.by("idMotivo").ascending());
  }

  @Override
  public Motivo guardar(Motivo entidad) {
    return motivoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    motivoDao.deleteById(id);
  }
}

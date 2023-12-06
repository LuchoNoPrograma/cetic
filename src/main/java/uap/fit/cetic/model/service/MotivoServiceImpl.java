package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IMotivoDao;
import uap.fit.cetic.model.entity.Motivo;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MotivoServiceImpl implements IMotivoService {
  private final IMotivoDao motivoDao;

  @Override
  public Motivo buscarPorId(Long id) {
    return motivoDao.findById(id).orElse(null);
  }

  @Override
  public Set<Motivo> buscarTodosPorIds(List<Long> ids) {
    return Set.copyOf(motivoDao.findAllById(ids));
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

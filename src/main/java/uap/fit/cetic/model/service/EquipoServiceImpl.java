package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IEquipoDao;
import uap.fit.cetic.model.entity.Equipo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements IEquipoService {
  private final IEquipoDao equipoDao;

  @Override
  public Equipo buscarPorId(Long id) {
    return equipoDao.findById(id).orElse(null);
  }

  @Override
  public List<Equipo> listarTodos() {
    return equipoDao.findAll(Sort.by(Sort.Direction.DESC, "codSerie"));
  }

  @Override
  public Equipo guardar(Equipo entidad) {
    return equipoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    equipoDao.deleteById(id);
  }
}

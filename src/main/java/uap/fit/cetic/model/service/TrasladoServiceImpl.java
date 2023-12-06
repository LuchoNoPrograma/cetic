package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ITrasladoDao;
import uap.fit.cetic.model.entity.Traslado;
import uap.fit.cetic.model.entity.TrasladoId;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrasladoServiceImpl implements ITrasladoService {
  private final ITrasladoDao trasladoDao;

  @Override
  public Traslado buscarPorId(TrasladoId id) {
    return trasladoDao.findById(id).orElse(null);
  }

  @Override
  public List<Traslado> listarTodos() {
    return trasladoDao.findAll(Sort.by("idEquipo").descending());
  }

  @Override
  public Traslado guardar(Traslado entidad) {
    return trasladoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(TrasladoId id) {
    trasladoDao.deleteById(id);
  }
}

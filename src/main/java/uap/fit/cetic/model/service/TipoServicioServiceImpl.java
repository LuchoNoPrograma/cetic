package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ITipoServicioDao;
import uap.fit.cetic.model.entity.TipoServicio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicioServiceImpl implements ITipoServicioService {
  private final ITipoServicioDao tipoServicioDao;
  @Override
  public TipoServicio buscarPorId(Long id) {
    return tipoServicioDao.findById(id).orElse(null);
  }

  @Override
  public List<TipoServicio> listarTodos() {
    return tipoServicioDao.findAll(Sort.by("idTipoServicio").descending());
  }

  @Override
  public TipoServicio guardar(TipoServicio entidad) {
    return tipoServicioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    tipoServicioDao.deleteById(id);
  }
}

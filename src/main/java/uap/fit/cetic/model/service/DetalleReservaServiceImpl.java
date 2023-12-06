package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IDetalleReservaDao;
import uap.fit.cetic.model.entity.DetalleReserva;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleReservaServiceImpl implements IDetalleReservaService {
  private final IDetalleReservaDao detalleReservaDao;

  @Override
  public DetalleReserva buscarPorId(Long id) {
    return detalleReservaDao.findById(id).orElse(null);
  }

  @Override
  public List<DetalleReserva> listarTodos() {
    return detalleReservaDao.findAll(Sort.by("idAsignacion").descending());
  }

  @Override
  public DetalleReserva guardar(DetalleReserva entidad) {
    return detalleReservaDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    detalleReservaDao.deleteById(id);
  }
}

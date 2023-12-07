package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IDetalleServicioDao;
import uap.fit.cetic.model.entity.DetalleServicio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleServicioServiceImpl implements IDetalleServicioService {
  private final IDetalleServicioDao detalleServicioDao;

  @Override
  public DetalleServicio buscarPorId(Long id) {
    return detalleServicioDao.findById(id).orElse(null);
  }

  @Override
  public List<DetalleServicio> listarTodos() {
    return detalleServicioDao.findAll(Sort.by("idDetalleServicio").descending());
  }

  @Override
  public DetalleServicio guardar(DetalleServicio entidad) {
    return detalleServicioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    detalleServicioDao.deleteById(id);
  }

  @Override
  public List<DetalleServicio> guardarTodos(List<DetalleServicio> listaServicio) {
    return detalleServicioDao.saveAll(listaServicio);
  }
}

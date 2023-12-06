package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IServicioDao;
import uap.fit.cetic.model.entity.Servicio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements IServicioService {
  private final IServicioDao servicioDao;

  @Override
  public Servicio buscarPorId(Long id) {
    return servicioDao.findById(id).orElse(null);
  }

  @Override
  public List<Servicio> listarTodos() {
    return servicioDao.findAll(Sort.by("idServicio").ascending());
  }

  @Override
  public Servicio guardar(Servicio entidad) {
    return servicioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    servicioDao.deleteById(id);
  }
}

package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IServicioDao;
import uap.fit.cetic.model.entity.Servicio;
import uap.fit.cetic.model.enums.EstadoServicio;

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

  public List<Servicio> listarTodosOrderByNroSolicitud() {
    return servicioDao.findAllOrderByNroSolicitudDesc();
  }

  @Override
  public Servicio guardar(Servicio entidad) {
    return servicioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    servicioDao.deleteById(id);
  }

  @Override
  public List<Servicio> guardarTodos(List<Servicio> listaServicio) {
    return servicioDao.saveAll(listaServicio);
  }

  @Override
  public List<Servicio> listarTodosSolicitudAceptada() {
    return servicioDao.findAllSolicitudAceptada();
  }

  @Override
  public Long contarPorEstadoServicio(EstadoServicio estadoServicio){
    return servicioDao.countByEstadoServicio(estadoServicio);
  }
}

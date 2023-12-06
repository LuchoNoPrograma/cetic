package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IReservaDao;
import uap.fit.cetic.model.entity.Reserva;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements IReservaService {
  private final IReservaDao reservaDao;

  @Override
  public Reserva buscarPorId(Long id) {
    return reservaDao.findById(id).orElse(null);
  }

  @Override
  public List<Reserva> listarTodos() {
    return reservaDao.findAll(Sort.by("idReserva").descending());
  }

  @Override
  public Reserva guardar(Reserva entidad) {
    return reservaDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    reservaDao.deleteById(id);
  }

  @Override
  public List<Reserva> listarPorNroSolicitud(Long nroSolicitud) {
    return reservaDao.listarPorNroSolicitud(nroSolicitud);
  }
}

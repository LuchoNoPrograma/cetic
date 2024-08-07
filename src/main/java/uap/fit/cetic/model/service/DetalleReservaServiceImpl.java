package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.dto.DetalleReservaDto;
import uap.fit.cetic.model.dao.IDetalleReservaDao;
import uap.fit.cetic.model.dao.ILaboratorioDao;
import uap.fit.cetic.model.dao.IReservaDao;
import uap.fit.cetic.model.entity.DetalleReserva;
import uap.fit.cetic.model.enums.EstadoReserva;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleReservaServiceImpl implements IDetalleReservaService {
  private final ILaboratorioDao laboratorioDao;
  private final IReservaDao reservaDao;
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

  @Override
  public DetalleReserva registrarNuevoDetalleReserva(DetalleReservaDto detalleReservaDto) {
    DetalleReserva detalleReserva = new DetalleReserva();
    detalleReserva.setFechaHoraInicio(detalleReservaDto.getFechaUso().atTime(detalleReservaDto.getHoraInicio()));
    detalleReserva.setFechaHoraFin(detalleReservaDto.getFechaUso().atTime(detalleReservaDto.getHoraFin()));
    detalleReserva.setReserva(reservaDao.findById(detalleReservaDto.getReservaIdReserva()).orElse(null));
    detalleReserva.setLaboratorio(laboratorioDao.findById(detalleReservaDto.getLaboratorioIdLaboratorio()).orElse(null));
    detalleReserva.setEstadoReserva(EstadoReserva.PENDIENTE);

    return detalleReservaDao.save(detalleReserva);
  }
}

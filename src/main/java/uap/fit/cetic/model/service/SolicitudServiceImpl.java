package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ISolicitudDao;
import uap.fit.cetic.model.entity.Solicitud;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements ISolicitudService {
  private final ISolicitudDao solicitudDao;

  @Override
  public Solicitud buscarPorId(Long id) {
    return solicitudDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
  }

  @Override
  public List<Solicitud> listarTodos() {
    return solicitudDao.findAll(Sort.by("fechaSolicitud").descending());
  }

  @Override
  public Solicitud guardar(Solicitud entidad) {
    return solicitudDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    solicitudDao.deleteById(id);
  }
}

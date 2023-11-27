package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IEquipoDao;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.enums.EstadoEquipo;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements IEquipoService {
  private final IEquipoDao equipoDao;

  @Override
  public Equipo buscarPorId(Long id) {
    return equipoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado con el id: " + id));
  }

  @Override
  public List<Equipo> listarTodos() {
    return equipoDao.findAll(Sort.by(Sort.Direction.DESC, "fechaRegistro"));
  }

  @Override
  public Equipo guardar(Equipo entidad) {
    if(entidad.getFechaRegistro() == null) entidad.setFechaRegistro(LocalDateTime.now());
    return equipoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    Equipo equipo = equipoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado con el id: " + id));
    equipo.setEstadoEquipo(EstadoEquipo.ELIMINADO);
    equipoDao.save(equipo);
  }
}

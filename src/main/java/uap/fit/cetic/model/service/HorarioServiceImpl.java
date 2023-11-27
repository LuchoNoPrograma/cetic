package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IHorarioDao;
import uap.fit.cetic.model.entity.Horario;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioServiceImpl implements IHorarioService {
  private final IHorarioDao horarioDao;

  @Override
  public Horario buscarPorId(Long id) {
    return horarioDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: "+id));
  }

  @Override
  public List<Horario> listarTodos() {
    return horarioDao.findAll(Sort.by("idHorario").ascending());
  }

  @Override
  public Horario guardar(Horario entidad) {
    return horarioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    horarioDao.deleteById(id);
  }
}

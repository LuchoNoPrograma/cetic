package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ITecnicoDao;
import uap.fit.cetic.model.entity.Tecnico;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TecnicoServiceImpl implements ITecnicoService {
  private final ITecnicoDao tecnicoDao;

  @Override
  public Tecnico buscarPorId(Long id) {
    return tecnicoDao.findById(id).orElse(null);
  }

  @Override
  public List<Tecnico> listarTodos() {
    return tecnicoDao.findAll(Sort.by("idTecnico").ascending());
  }

  @Override
  public Tecnico guardar(Tecnico entidad) {
    return tecnicoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    tecnicoDao.deleteById(id);
  }
}

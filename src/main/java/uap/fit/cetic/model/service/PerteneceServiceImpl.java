package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IPerteneceDao;
import uap.fit.cetic.model.entity.Pertenece;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerteneceServiceImpl implements IPerteneceService {
  private final IPerteneceDao perteneceDao;

  @Override
  public Pertenece buscarPorId(Long id) {
    return perteneceDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: "+id));
  }

  @Override
  public List<Pertenece> listarTodos() {
    return perteneceDao.findAll(Sort.by("fechaRegistro").descending());
  }

  @Override
  public Pertenece guardar(Pertenece entidad) {
    return perteneceDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    perteneceDao.deleteById(id);
  }
}

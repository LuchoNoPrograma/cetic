package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ILaboratorioDao;
import uap.fit.cetic.model.entity.Laboratorio;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaboratorioServiceImpl implements ILaboratorioService {
  private final ILaboratorioDao laboratorioDao;

  @Override
  public Laboratorio buscarPorId(Long id) {
    return laboratorioDao.findById(id).orElse(null);
  }

  @Override
  public List<Laboratorio> listarTodos() {
    return laboratorioDao.findAll(Sort.by("nombre").ascending());
  }

  @Override
  public List<Laboratorio> listarTodosDisponibles(){
    return laboratorioDao.findAllDisponibles();
  }

  @Override
  public Laboratorio guardar(Laboratorio entidad) {
    return laboratorioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    laboratorioDao.deleteById(id);
  }
}

package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IPersonaDao;
import uap.fit.cetic.model.entity.Persona;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements IPersonaService {
  private final IPersonaDao dao;

  @Override
  public Persona buscarPorId(Long id) {
    return dao.findById(id).orElse(null);
  }

  @Override
  public List<Persona> listarTodos() {
    return dao.findAll();
  }

  @Override
  public Persona guardar(Persona persona) {
    return dao.save(persona);
  }

  @Override
  public void eliminarPorId(Long id) {
    dao.deleteById(id);
  }
}

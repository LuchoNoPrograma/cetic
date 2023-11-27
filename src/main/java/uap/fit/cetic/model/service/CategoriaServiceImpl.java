package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.ICategoriaDao;
import uap.fit.cetic.model.entity.Categoria;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {
  private final ICategoriaDao categoriaDao;

  @Override
  public Categoria buscarPorId(Long id) {
    return categoriaDao.findById(id).orElseThrow(() -> new EntityNotFoundException("No se encontro la categoria con el id: " + id));
  }

  @Override
  public List<Categoria> listarTodos() {
    return categoriaDao.findAll(Sort.by("idCategoria").ascending());
  }

  @Override
  public Categoria guardar(Categoria entidad) {
    return categoriaDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    categoriaDao.deleteById(id);
  }
}

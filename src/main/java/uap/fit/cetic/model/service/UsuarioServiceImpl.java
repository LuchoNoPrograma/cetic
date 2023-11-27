package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IUsuarioDao;
import uap.fit.cetic.model.entity.Usuario;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
  private final IUsuarioDao usuarioDao;

  @Override
  public Usuario buscarPorId(Long id) {
    return usuarioDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
  }

  @Override
  public List<Usuario> listarTodos() {
    return usuarioDao.findAll(Sort.by("idUsuario").ascending());
  }

  @Override
  public Usuario guardar(Usuario entidad) {
    return usuarioDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    usuarioDao.deleteById(id);
  }
}

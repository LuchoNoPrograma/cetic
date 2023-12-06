package uap.fit.cetic.model.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uap.fit.cetic.model.dao.IMenuDao;
import uap.fit.cetic.model.entity.Menu;
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements IMenuService{
    private final IMenuDao menuDao;


    @Override
    public Menu buscarPorId(Long id) {
      return menuDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
    }

    @Override
    public List<Menu> listarTodos() {
       return menuDao.findAll(Sort.by("idMenu").ascending());
    }

    @Override
    public Menu guardar(Menu entidad) {
        return menuDao.save(entidad);
    }

    @Override
    public void eliminarPorId(Long id) {
        menuDao.deleteById(id);
    }
    
}

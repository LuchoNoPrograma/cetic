package uap.fit.cetic.model.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import uap.fit.cetic.model.dao.IEnlaceDao;
import uap.fit.cetic.model.entity.Enlace;
@Service
@RequiredArgsConstructor
public class EnlaceServiceImpl implements IEnlaceService{
    private final IEnlaceDao enlaceDao;

    @Override
    public Enlace buscarPorId(Long id) {
       return enlaceDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: " + id));
    }

    @Override
    public List<Enlace> listarTodos() {
       return enlaceDao.findAll(Sort.by("idEnlace").ascending());
    }

    @Override
    public Enlace guardar(Enlace entidad) {
        return enlaceDao.save(entidad);
    }

    @Override
    public void eliminarPorId(Long id) {
        enlaceDao.deleteById(id);
    }
  

}

package uap.fit.cetic.model.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.dao.IPagoDao;
import uap.fit.cetic.model.entity.Pago;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements IPagoService {
  private final IPagoDao pagoDao;

  @Override
  public Pago buscarPorId(Long id) {
    return pagoDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Registro no encontrado con el id: "+id));
  }

  @Override
  public List<Pago> listarTodos() {
    return pagoDao.findAll(Sort.by("fechaPago").descending());
  }

  @Override
  public Pago guardar(Pago entidad) {
    return pagoDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    pagoDao.deleteById(id);
  }
}

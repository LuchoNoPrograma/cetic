package uap.fit.cetic.model.service;

import java.util.List;

public interface IServiceGenerico <E, I>{
  E buscarPorId(I id);
  List<E> listarTodos();
  E guardar(E entidad);
  void eliminarPorId(I id);
}

package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.Servicio;
import uap.fit.cetic.model.enums.EstadoServicio;

import java.util.List;

public interface IServicioService extends IServiceGenerico<Servicio, Long> {
  List<Servicio> guardarTodos(List<Servicio> listaServicio);
  List<Servicio> listarTodosSolicitudAceptada();

  Long contarPorEstadoServicio(EstadoServicio estadoServicio);
}

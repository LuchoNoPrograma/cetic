package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.DetalleReserva;
import uap.fit.cetic.model.entity.DetalleServicio;

import java.util.List;

public interface IDetalleServicioService extends IServiceGenerico<DetalleServicio, Long> {
  List<DetalleServicio> guardarTodos(List<DetalleServicio> listaServicio);
}

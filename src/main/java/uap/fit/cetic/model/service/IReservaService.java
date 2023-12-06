package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.Reserva;

import java.util.List;

public interface IReservaService extends IServiceGenerico<Reserva, Long> {
  List<Reserva> listarPorNroSolicitud(Long nroSolicitud);
}

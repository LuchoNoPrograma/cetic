package uap.fit.cetic.model.service;

import uap.fit.cetic.dto.DetalleReservaDto;
import uap.fit.cetic.model.entity.DetalleReserva;

public interface IDetalleReservaService extends IServiceGenerico<DetalleReserva, Long> {
    DetalleReserva registrarNuevoDetalleReserva(DetalleReservaDto detalleReservaDto);
}

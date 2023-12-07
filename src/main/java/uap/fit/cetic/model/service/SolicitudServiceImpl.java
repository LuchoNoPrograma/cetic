package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uap.fit.cetic.dto.DetalleServicioDto;
import uap.fit.cetic.dto.SolicitudDto;
import uap.fit.cetic.model.dao.ISolicitudDao;
import uap.fit.cetic.model.entity.*;
import uap.fit.cetic.model.enums.EstadoReserva;
import uap.fit.cetic.model.enums.EstadoServicio;
import uap.fit.cetic.model.enums.EstadoSolicitud;
import uap.fit.cetic.model.enums.TipoSolicitud;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements ISolicitudService {
  private final ISolicitudDao solicitudDao;
  private final IServicioService servicioService;
  private final ModelMapper modelMapper;
  private final IDetalleServicioService detalleServicioService;

  @Override
  public Solicitud buscarPorId(Long id) {
    return solicitudDao.findById(id).orElse(null);
  }

  @Override
  public List<Solicitud> listarTodos() {
    return solicitudDao.findAll(Sort.by("fechaSolicitud").descending());
  }

  @Override
  public Solicitud guardar(Solicitud entidad) {
    /*if(entidad.getFechaSolicitud() == null) entidad.setFechaSolicitud(LocalDateTime.now());
    if(entidad.getEstadoSolicitud() == null) entidad.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);*/
    return solicitudDao.save(entidad);
  }

  @Override
  public void eliminarPorId(Long id) {
    solicitudDao.deleteById(id);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Solicitud guardarDto(SolicitudDto solicitudDto) {
    Solicitud solicitud = modelMapper.map(solicitudDto, Solicitud.class);

    if (solicitudDto.getTipoSolicitud() == TipoSolicitud.RESERVA_DE_LABORATORIO) {
      solicitud.setListaServicio(null);
      Reserva reserva = modelMapper.map(solicitudDto.getReserva(), Reserva.class);
      solicitud.setReserva(reserva);
      reserva.setEstadoReserva(EstadoReserva.PENDIENTE);

      this.guardar(solicitud);
    } else {
      solicitud.setReserva(null);
      if (solicitud.getFechaSolicitud() == null) solicitud.setFechaSolicitud(LocalDateTime.now());
      if (solicitud.getEstadoSolicitud() == null) solicitud.setEstadoSolicitud(EstadoSolicitud.PENDIENTE);
      solicitud.setListaServicio(null);
      Solicitud solicitudPersistido = this.guardar(solicitud);

      List<Servicio> listaServicio = solicitudDto.getListaServicio().stream().map(servicioDto -> {
        Servicio servicio = modelMapper.map(servicioDto, Servicio.class);
        Equipo equipo = modelMapper.map(servicioDto.getEquipo(), Equipo.class);
        List<Motivo> listaMotivo = servicioDto.getListaMotivo().stream().map(motivoDto -> modelMapper.map(motivoDto, Motivo.class)).toList();

        servicio.setSolicitud(Solicitud.builder().nroSolicitud(solicitudPersistido.getNroSolicitud()).build());
        servicio.setEquipo(equipo);
        servicio.setListaMotivo(Set.copyOf(listaMotivo));
        return servicio;
      }).toList();

      solicitud.setListaServicio(servicioService.guardarTodos(listaServicio));
    }

    return solicitud;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Solicitud aceptarSolicitudTecnica(SolicitudDto solicitudDto) {
    Solicitud original = this.buscarPorId(solicitudDto.getNroSolicitud());
    Solicitud solicitud = modelMapper.map(solicitudDto, Solicitud.class);
    solicitud.setEstadoSolicitud(EstadoSolicitud.ACEPTADA);
    solicitud.setFechaSolicitud(original.getFechaSolicitud());
    Solicitud solicitudPersistido = this.guardar(solicitud);

    List<Servicio> listaServicio = solicitudDto.getListaServicio().stream().map(servicioDto -> {
      Servicio servicio = modelMapper.map(servicioDto, Servicio.class);
      Equipo equipo = modelMapper.map(servicioDto.getEquipo(), Equipo.class);

      List<DetalleServicio> listaDetalleServicio = servicioDto.getListaDetalleServicio()
        .stream().map(detalleServicioDto -> modelMapper.map(detalleServicioDto, DetalleServicio.class))
        .toList();

      List<Asignacion> listaAsignacion = servicioDto.getListaTecnico()
        .stream().map(tecnicoDto -> Asignacion.builder()
          .tecnico(modelMapper.map(tecnicoDto, Tecnico.class))
          .servicio(servicio)
          .fechaAsignacion(LocalDateTime.now())
          .build())
        .toList();

      servicio.setSolicitud(Solicitud.builder().nroSolicitud(solicitudPersistido.getNroSolicitud()).build());
      servicio.setEstadoServicio(EstadoServicio.PENDIENTE);
      servicio.setEquipo(equipo);
      servicio.setListaDetalleServicio(listaDetalleServicio);
      servicio.setListaAsignacion(listaAsignacion);

      return servicio;
    }).toList();

    solicitud.setListaServicio(servicioService.guardarTodos(listaServicio));
    /*
    * No tengo tiempo para optimizar, mi proyecto es en una hora, tengo que hacerlo como sea
    * */
    solicitud.getListaServicio().forEach(servicio -> {
      List<DetalleServicio> listaDetalleServicio = servicio.getListaDetalleServicio().stream().map(ds -> {
        DetalleServicio detalleServicio = modelMapper.map(ds, DetalleServicio.class);
        detalleServicio.setServicio(servicio);
        return detalleServicio;
      }).toList();

      servicio.setListaDetalleServicio(detalleServicioService.guardarTodos(listaDetalleServicio));
    });
    return this.guardar(solicitud);
  }
}

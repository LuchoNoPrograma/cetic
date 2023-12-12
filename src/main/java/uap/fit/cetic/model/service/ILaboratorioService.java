package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.Laboratorio;

import java.util.List;

public interface ILaboratorioService extends IServiceGenerico<Laboratorio, Long> {

  List<Laboratorio> listarTodosDisponibles();
}

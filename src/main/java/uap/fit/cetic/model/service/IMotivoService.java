package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.Motivo;

import java.util.List;
import java.util.Set;

public interface IMotivoService extends IServiceGenerico<Motivo, Long> {
  Set<Motivo> buscarTodosPorIds(List<Long> ids);
}

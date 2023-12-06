package uap.fit.cetic.model.service;

import uap.fit.cetic.model.entity.Usuario;

public interface IUsuarioService extends IServiceGenerico<Usuario, Long> {
  Usuario buscarPorUsername(String username);
}

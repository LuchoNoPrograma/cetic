package uap.fit.cetic.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uap.fit.cetic.model.entity.Usuario;
import uap.fit.cetic.model.service.IUsuarioService;

/**
 * Servicio propio de SpringSecurity para manejar a un UserDetails y sus GrantedAuthority
 * para manejar los permisos
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
  @Autowired
  private IUsuarioService usuarioService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioService.buscarPorUsername(username);
    if (usuario == null) throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    return new UserDetailsImpl(usuario);
  }

}
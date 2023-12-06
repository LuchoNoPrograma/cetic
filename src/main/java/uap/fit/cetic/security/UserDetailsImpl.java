package uap.fit.cetic.security;

public class UserDetailsImpl{}

/**
import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import uap.fit.cetic.model.entity.Usuario;

 * Al instanciar la clase se establece SecUsuario y empezar la Conversion
 * a la clase UserDetails para el manejo de Seguridad de SpringSecurity
 */
/*
public class UserDetailsImpl implements UserDetails {

  private Usuario usuario;

  public UserDetailsImpl(Usuario usuario) {
   this.usuario = usuario;
  }

  public Long getId() {
    return usuario.getIdUsuario();
  }

  */
/**
   * Tanto ROLE y AUTHORITY pertenecen a la clase SimpleGrantedAuthority
   *
   * ROLE_ es un prefijo para diferenciar de un
   * AUTHORITY
   *
   * Requerido establecerlo para poder realizar permisos de acceso a metodos de @Controller o @RestController
   *
   *
   * Utilizar la anotacion: Para restringir acceso a metodos de @Controller que tengan de parametro @PathVariable
   * @PreAuthorize (metodoEspecial("Nombre"))            -> Nombre Original en BD
   * @PostAuthorize (metodoEspecial("Nombre"))           -> Nombre Original en BD
   *
   *
   * @PreAuthorize (hasRole("NOMBRE_ROLE"))              -> ROLE_NOMBRE_ROLE
   * @PreAuthorize (hasAnyRole("NOMBRE_ROLE"))           -> ROLE_NOMBRE_ROLE
   * @PreAuthorize (hasAuthority("ROLE_NOMBRE_ROLE"))    -> ROLE_NOMBRE_ROLE
   * @PreAuthorize (hasAnyAuthority("ROLE_NOMBRE_ROLE")) -> ROLE_NOMBRE_ROLE
   *
   * @PreAuthorize (hasAuthority("NOMBRE_AUTORIDAD"))    -> NOMBRE_AUTORIDAD
   * @PreAuthorize (hasAnyAuthority("NOMBRE_AUTORIDAD")) -> NOMBRE_AUTORIDAD
   *//*

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> authorities = new HashSet<>();

    usuario.getListaPermiso().forEach(autoridad ->{
      authorities.add(new SimpleGrantedAuthority(autoridad.getNombrePermiso()));
    });

    return authorities;
  }

  @Override
  public String getPassword() {
    return usuario.getPassword();
  }

  @Override
  public String getUsername() {
    return usuario.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return usuario.getEnabled();
  }
}*/

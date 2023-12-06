package uap.fit.cetic.controller;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.service.IEquipoService;
import uap.fit.cetic.model.service.IClienteService;
import uap.fit.cetic.model.service.IMenuService;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
  private final DataSource dataSource;
  private final IClienteService personaService;
  private final IEquipoService equipoService;
  private final IMenuService menuService;


  /*@GetMapping("/index")
  public String index(Model model) {
    *//*Map<String, Object> datos = new HashMap<>();
    datos.put("username", "user");
    datos.put("password", "1234");
    datos.put("enabled", false);
    genericRepository.insertar("usuario", datos);*//*

    GenericRepository genericRepository = new GenericRepository(new JdbcTemplate(dataSource));
    List<Usuario> listaUsuario = genericRepository.listarTodos(Usuario.class, List.of("id_usuario", "username", "password"));
    *//*listaUsuario.forEach(System.out::println);*//*
    System.out.println(listaUsuario.size());
    model.addAttribute("listaUsuario", listaUsuario);
    return "index";
  }*/

  @GetMapping({"/index", "/", "/inicio", "/home"})
  public String index(Model model, HttpSession session) {
    List<Equipo> listaEquipo = equipoService.listarTodos();
    session.setAttribute("listaMenus", menuService.listarTodos());
    return "index";
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

}

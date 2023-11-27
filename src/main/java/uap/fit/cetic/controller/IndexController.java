package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uap.fit.cetic.model.dao.IPersonaDao;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.entity.Usuario;
import uap.fit.cetic.model.repository.GenericRepository;
import uap.fit.cetic.model.service.IEquipoService;
import uap.fit.cetic.model.service.IPersonaService;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
  private final DataSource dataSource;
  private final IPersonaService personaService;
  private final IEquipoService equipoService;


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

  @GetMapping("/index")
  public String index(Model model){
    List<Equipo> listaEquipo = equipoService.listarTodos();
    model.addAttribute("listaEquipo", listaEquipo);
    return "index";
  }

}

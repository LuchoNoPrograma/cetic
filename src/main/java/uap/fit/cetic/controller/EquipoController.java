package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.service.ICategoriaService;
import uap.fit.cetic.model.service.IEquipoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/equipo")
public class EquipoController {
  private final IEquipoService equipoService;
  private final ICategoriaService categoriaService;

  @GetMapping("/lista")
  public String lista(Model model){
    model.addAttribute("listaEquipo", equipoService.listarTodos());
    return "vista-equipo/equipo-lista";
  }

  @GetMapping("/form-registrar")
  public String formRegistro(Model model){
    model.addAttribute("listaCategoria", categoriaService.listarTodos());
    model.addAttribute("equipo", new Equipo());
    return "vista-equipo/equipo-form";
  }

  @GetMapping("/form-modificar/{idEquipo}")
  public String formModificar(Model model, @PathVariable Long idEquipo){
    model.addAttribute("listaCategoria", categoriaService.listarTodos());
    model.addAttribute("equipo", equipoService.buscarPorId(idEquipo));
    return "vista-equipo/equipo-form";
  }

  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Equipo equipo){
    equipoService.guardar(equipo);
    return "redirect:/equipo/lista";
  }

  @ResponseBody
  @DeleteMapping("/{idEquipo}")
  public ResponseEntity<String> eliminar(@PathVariable Long idEquipo){
    equipoService.eliminarPorId(idEquipo);
    return ResponseEntity.ok("Equipo eliminado correctamente, id: "+idEquipo);
  }

}


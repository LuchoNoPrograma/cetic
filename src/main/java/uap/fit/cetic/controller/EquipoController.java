package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uap.fit.cetic.model.entity.Equipo;
import uap.fit.cetic.model.enums.Categoria;
import uap.fit.cetic.model.service.IEquipoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/equipo")
public class EquipoController {
  //Aqui se llama al servicio que tiene los datos de la base de datos
  private final IEquipoService equipoService;

  //Metodos envia datos en un html procesado
  @GetMapping("/lista")
  public String lista(Model model) {
    //model es para enviar datos de tu logica a tu vista, esto se puede utilizar cuando
    //utilizas el signo de pesitos ${}, ejemplo:
    // <option th:each="categoria : ${listaCategoria}">
    model.addAttribute("listaEquipo", equipoService.listarTodos());
    return "vista-equipo/equipo-lista";
  }

  //Este metodo de get es para enviar datos a la vista
  @GetMapping("/form-registrar")
  public String formRegistro(Model model) {
    model.addAttribute("listaCategoria", Categoria.values());
    model.addAttribute("equipo", new Equipo());
    return "vista-equipo/equipo-form";
  }

  //Este metodo de get es para enviar datos a la vista
  @GetMapping("/form-modificar/{idEquipo}")
  public String formModificar(Model model, @PathVariable Long idEquipo) {
    model.addAttribute("listaCategoria", Categoria.values());
    model.addAttribute("equipo", equipoService.buscarPorId(idEquipo));
    return "vista-equipo/equipo-form";
  }

  //PostMapping es para registrar o actualizar
  @PostMapping("/registrar")
  public String registrar(@ModelAttribute Equipo equipo) {
    equipoService.guardar(equipo);
    return "redirect:/equipo/lista";
  }

  /*
  * ResponseBody permite enviar datos AJAX a la vista
  * */
  @ResponseBody
  @DeleteMapping("/{idEquipo}")
  public ResponseEntity<String> eliminar(@PathVariable Long idEquipo) {
    equipoService.eliminarPorId(idEquipo);
    return ResponseEntity.ok("Equipo eliminado correctamente, id: " + idEquipo);
  }

  @ResponseBody
  @GetMapping("/categorias")
  public ResponseEntity<?> categorias(Model model) {
    return ResponseEntity.ok(Categoria.values());
  }
}


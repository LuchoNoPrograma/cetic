package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import uap.fit.cetic.model.entity.Laboratorio;
import uap.fit.cetic.model.enums.Categoria;
import uap.fit.cetic.model.service.ILaboratorioService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/laboratorio")
public class LaboratorioController {
  private final ILaboratorioService laboratorioService;

  @GetMapping("/lista")
  public String listar(Model model) {
    model.addAttribute("listaLAboratorio", laboratorioService.listarTodos());
    return "laboratorio/lista";
  }
   //Este metodo de get es para enviar datos a la vista
  @GetMapping("/form-registrar")
  public String formRegistro(Model model) {
    model.addAttribute("listaCategoria", Categoria.values());
    model.addAttribute("laboratorio", new Laboratorio());
    return "vista-laboratorio/laboratorio-form";
  }

  //Este metodo de get es para enviar datos a la vista
  @GetMapping("/form-modificar/{idLaboratorio}")
  public String formModificar(Model model, @PathVariable Long idLaboratorio) {
    model.addAttribute("listaCategoria", Categoria.values());
    model.addAttribute("laboratorio", laboratorioService.buscarPorId(idLaboratorio));
    return "vista-laboratorio/laboratorio-form";
  }
    @PostMapping("/registrar")
  public String registrar(@ModelAttribute Laboratorio laboratorio) {
    laboratorioService.guardar(laboratorio);
    return "redirect://lista";
  }
  @ResponseBody
  @DeleteMapping("/{idLaboratorio}")
  public ResponseEntity<String> eliminar(@PathVariable Long idLaboratorio) {
    laboratorioService.eliminarPorId(idLaboratorio);  
    return ResponseEntity.ok("Laboratorio eliminado correctamente, id: " + idLaboratorio); 
  }
  
}

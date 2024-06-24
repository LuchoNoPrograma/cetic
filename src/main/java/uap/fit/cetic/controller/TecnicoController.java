package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uap.fit.cetic.model.service.ITecnicoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tecnico")
public class TecnicoController {
  private final ITecnicoService tecnicoService;

  @GetMapping("/lista")
  public String lista(Model model){
    model.addAttribute("listaTecnico", tecnicoService.listarTodos());
    return "vista-tecnico/tecnico-lista";
  }
}

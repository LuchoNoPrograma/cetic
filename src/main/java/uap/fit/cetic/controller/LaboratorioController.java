package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uap.fit.cetic.model.service.ILaboratorioService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/laboratorio")
public class LaboratorioController {
  private final ILaboratorioService laboratorioService;

  @GetMapping("/lista")
  public String listar(Model model) {
    return "laboratorio/lista";
  }
}

package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uap.fit.cetic.model.entity.Cliente;
import uap.fit.cetic.model.service.IClienteService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
  private final IClienteService clienteService;

  @GetMapping("/lista")
  public String lista(Model model) {
    model.addAttribute("listaCliente", clienteService.listarTodos());
    return "vista-cliente/cliente-lista";
  }

  @GetMapping("/formulario")
  public String verFormulario(Model model, @RequestParam(required = false) Long idCliente) {
    Cliente cliente = new Cliente();

    if(idCliente != null) cliente = clienteService.buscarPorId(idCliente);

    model.addAttribute("cliente", cliente);
    return "vista-cliente/cliente-form";
  }

  @PostMapping("/registrar")
  public String registrar(Cliente cliente) {
    clienteService.guardar(cliente);
    return "redirect:/cliente/lista";
  }
}

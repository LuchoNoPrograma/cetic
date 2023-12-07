package uap.fit.cetic.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uap.fit.cetic.dto.TecnicoDto;
import uap.fit.cetic.model.service.ITecnicoService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/asignacion")
public class AsignacionController {
  private final ITecnicoService tecnicoService;
  private final ModelMapper modelMapper;

  @ResponseBody
  @GetMapping("/api/v1/tecnicos/disponibles")
  public ResponseEntity<List<TecnicoDto>> findAllTecnicos() {
    List<TecnicoDto> listaTecnicoDto = tecnicoService.listarTodos().stream()
      .map(t -> modelMapper.map(t, TecnicoDto.class)).toList();

    return ResponseEntity.ok().body(listaTecnicoDto);
  }
}

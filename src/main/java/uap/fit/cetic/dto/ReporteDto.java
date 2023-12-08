package uap.fit.cetic.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.ByteArrayInputStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDto {
  private String fileName;
  private ByteArrayInputStream stream;
  private int length;
}

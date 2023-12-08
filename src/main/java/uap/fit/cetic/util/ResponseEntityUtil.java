package uap.fit.cetic.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import uap.fit.cetic.dto.ReporteDto;

public class ResponseEntityUtil {
  public static ResponseEntity<?> getResponseEntityPdf(ReporteDto reporteDto) {
    InputStreamResource streamResource = new InputStreamResource(reporteDto.getStream());
    ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
      .filename(reporteDto.getFileName()).build();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentDisposition(contentDisposition);

    return ResponseEntity.ok()
      .headers(headers)
      .contentLength(reporteDto.getLength())
      .contentType(MediaType.APPLICATION_PDF)
      .body(streamResource);
  }
}

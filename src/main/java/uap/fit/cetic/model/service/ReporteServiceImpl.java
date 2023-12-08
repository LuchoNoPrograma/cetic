package uap.fit.cetic.model.service;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.stereotype.Service;
import uap.fit.cetic.dto.ReporteDto;
import uap.fit.cetic.model.entity.Solicitud;
import uap.fit.cetic.util.JasperReportManager;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements IReporteService {
  private final DataSource dataSource;
  private final JasperReportManager reportManager;
  @Override
  public ReporteDto reporteInformeServiciosEquipos(Solicitud solicitud) {
    String archivoOriginal = "informe_servicios_equipos";

    String nombreArchivo = "INFORME DE SERVICIOS DE EQUIPOS";

    ReporteDto dto = new ReporteDto();
    dto.setFileName(nombreArchivo + ".pdf");

    Map<String, Object> params = new HashMap<>();
    params.put("logo_uap", "http://virtual.uap.edu.bo:6061/images/posgrado/logo_uap.png");
    params.put("nro_solicitud", solicitud.getNroSolicitud());
    params.put("fecha_solicitud", this.getFechaImpresion(solicitud.getFechaSolicitud()));
    params.put("fecha_entrega", this.getFechaImpresion());
    params.put("nombre_completo", solicitud.getCliente().getNombre()+" "+solicitud.getCliente().getApellidos());
    params.put("ci", solicitud.getCliente().getCi());
    params.put("celular", solicitud.getCliente().getCelular());
    params.put("nombre_completo_tecnico", solicitud.getTecnico().getNombre()+" "+solicitud.getTecnico().getApellidos());

    return getReporteDto(archivoOriginal, dto, params);
  }

  private ReporteDto getReporteDto(String archivoOriginal, ReporteDto dto, Map<String, Object> params) {
    try {
      ByteArrayOutputStream stream = reportManager.compilarAndExportarReporte(archivoOriginal, params, dataSource.getConnection());
      byte[] bs = stream.toByteArray();
      dto.setStream(new ByteArrayInputStream(bs));
      dto.setLength(bs.length);
      return dto;
    } catch (JRException | IOException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private String getFechaImpresion(LocalDateTime localDateTime) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    return localDateTime.format(formatter);
  }
  private String getFechaImpresion() {
    return this.getFechaImpresion(LocalDateTime.now());
  }
}

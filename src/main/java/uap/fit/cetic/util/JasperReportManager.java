package uap.fit.cetic.util;

import net.sf.jasperreports.engine.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Component
public class JasperReportManager {
  private static final String REPORT_FOLDER = "reportes";
  private static final String JRXML = ".jrxml";
  private static final String JASPER = ".jasper";


  public ByteArrayOutputStream compilarAndExportarReporte(String original, Map<String, Object> params, Connection con) throws IOException, JRException {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    ClassPathResource resource = new ClassPathResource(REPORT_FOLDER + File.separator + original + JRXML);

    InputStream reportStream = resource.getInputStream();

    try {
      JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
      JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
    } finally {
      // Cerrar la conexión en el bloque finally para garantizar su cierre
      if (con != null) {
        try {
          con.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

    return stream;
  }
}
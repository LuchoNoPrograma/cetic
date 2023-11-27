package uap.fit.cetic.model.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericRepository {
  private final JdbcTemplate jdbcTemplate;

  public GenericRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void insertar(String tabla, Map<String, Object> datos) {
    String columnas = String.join(",", datos.keySet());

    datos.entrySet().forEach(entry -> {
      Object value = entry.getValue();
      if (value instanceof String) {
        value = "'" + value + "'";
        entry.setValue(value);
      }
    });

    String valores = datos.values().stream()
      .map(Object::toString)
      .collect(Collectors.joining(","));

    String sql = "INSERT INTO " + tabla + " " +
      "(" + columnas + ") " +
      "VALUES (" + valores + ")";

    System.out.println(sql);
    jdbcTemplate.execute(sql);
  }

  public <T> List<T> listarTodos(Class<T> claseEntidad, List<String> columnas) {
    String nombreTabla = claseEntidad.getAnnotation(Table.class).name();
    String atributoId = Arrays.stream(claseEntidad.getDeclaredFields()).filter(f -> f.isAnnotationPresent(Id.class)).findFirst().get().getAnnotation(Column.class).name();

    String sql = "SELECT " + String.join(",", columnas) + " FROM " + nombreTabla + " ORDER BY "+atributoId;
    System.out.println(sql);
    return jdbcTemplate.query(sql, (rs, rowNum) -> {
      T T;
      try {
        T = claseEntidad.getConstructor().newInstance();
        System.out.println("Entidad a mapear: " + T.getClass().getSimpleName());
        System.out.println("Columnas seleccionadas para mapear: (" + String.join(", ", columnas) + ")");
        Field[] atributos = T.getClass().getDeclaredFields();
        List<Field> atributosSeleccionados = Arrays.stream(atributos).filter(f -> columnas.contains(f.getAnnotation(Column.class).name())).toList();

        System.out.println("Lista de atributos seleccionados: (" + String.join(", ", atributosSeleccionados.stream().map(Field::getName).toList()) + ")");

        do{
          atributosSeleccionados.forEach(f -> {
            f.setAccessible(true);
            try {
              f.set(T, rs.getObject(f.getAnnotation(Column.class).name()));
            } catch (IllegalAccessException | SQLException e) {
              throw new RuntimeException(e);
            }
          });
          System.out.println(T);
        }
        while (rs.next());
        return T;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
  }
}

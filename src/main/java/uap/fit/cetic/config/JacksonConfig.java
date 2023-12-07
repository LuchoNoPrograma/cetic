package uap.fit.cetic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    /*SE AGREGA EL MODULO PARA PODER TRABAJAR CON LA API DE java.time (LocalDate, LocalDateTime, etc)*/
    objectMapper.registerModule(new JavaTimeModule());

    /*SE AGREGA EL MODULO PARA LA SERIALIZACION CON LAZY O EAGER
     * Ejemplo:
     * Evitar cargar los modulos con programa cuando modulo tiene un programa pero la carga es LAZY
     * (PERESOZA Y SE CARGA CUANDO LE ESPECIFIQUEMOS CUANDO QUEREMOS EL PROGAMA)
     *
     * Solo aplica a la serializacion a JSON
     * */
    objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    return objectMapper;
  }
}

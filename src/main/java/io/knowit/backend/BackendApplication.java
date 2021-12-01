package io.knowit.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.knowit.backend.config.AppProperties;
import io.knowit.backend.proto.request.content.ContentRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * TODO: Add verbose exception handling...
 * TODO: Return list of errors for invalid requests...
 */
@EnableConfigurationProperties(AppProperties.class)
@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
////        String jsonString = "{\"time\":1590738410297,\"blocks\":[{\"type\":\"header\",\"data\":{\"text\":\"What are we learning today?\",\"level\":3}},{\"type\":\"paragraph\",\"data\":{\"text\":\"Hello Nigga\"}},{\"type\":\"table\",\"data\":{\"content\":[[\"Well\",\"sdfsdf\"],[\"dsfsdf\",\"sdfsdfsdf\"]]}},{\"type\":\"list\",\"data\":{\"style\":\"ordered\",\"items\":[\"sdfsdf\",\"sdf\",\"sdf\"]}},{\"type\":\"qa\",\"data\":{\"title\":\"Question + Answer\",\"question\":\"\",\"answer\":\"\"}},{\"type\":\"paragraph\",\"data\":{\"text\":\"sdfidsf\"}},{\"type\":\"header\",\"data\":{\"text\":\"Some more STUFF!\",\"level\":2}},{\"type\":\"paragraph\",\"data\":{\"text\":\"Some more stuff&nbsp;\"}}],\"version\":\"2.17.0\"}";
//
//        String jsonString = "{\"time\":1590738410297,\"blocks\":[{\"type\":\"header\",\"data\":" +
//                "{\"text\":\"What are we learning today?\",\"level\":3}},{\"type\":\"paragraph\"," +
//                "\"data\":{\"text\":\"Hello Nigga\"}},{\"type\":\"table\",\"data\":{\"content\":" +
//                "[[\"Well\",\"sdfsdf\"],[\"dsfsdf\",\"sdfsdfsdf\"]]}},{\"type\":\"list\",\"data\"" +
//                ":{\"style\":\"ordered\",\"items\":[\"sdfsdf\",\"sdf\",\"sdf\"]}},{\"type\":\"qa\"" +
//                ",\"data\":{\"title\":\"Question + Answer\",\"question\":\"\",\"answer\":\"\"}}," +
//                "{\"type\":\"paragraph\",\"data\":{\"text\":\"sdfidsf\"}},{\"type\":\"header\",\"data\"" +
//                ":{\"text\":\"Some more STUFF!\",\"level\":2}},{\"type\":\"paragraph\",\"data\":{\"text\"" +
//                ":\"Some more stuff&nbsp;\"}}],\"version\":\"2.17.0\"}";
//
//        ContentRequest content = objectMapper.readValue(jsonString, ContentRequest.class);
//
//        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(content));

        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


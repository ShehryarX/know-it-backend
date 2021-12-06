package io.knowit.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@PropertySource("classpath:openai.key")
@ConfigurationProperties(prefix = "openai")
public class OpenAiProperties {
    /**
     * OpenAI token/secret key. Stored in the properties file.
     */
    public final String secret;

    public OpenAiProperties() throws IOException {
        secret = StreamUtils.copyToString(OpenAiProperties.class.getClassLoader().getResourceAsStream("openai.key"), StandardCharsets.UTF_8);
    }
}

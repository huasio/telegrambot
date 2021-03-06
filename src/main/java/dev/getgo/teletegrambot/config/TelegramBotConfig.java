package dev.getgo.teletegrambot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author UnAfraid
 */
@Configuration
public class TelegramBotConfig {
    @Value("${TELEGRAM_TOKEN}")
    @NotNull
    @NotEmpty
    private String token;

    @Value("${TELEGRAM_USERNAME}")
    @NotNull
    @NotEmpty
    private String username;

    @Value("${TELEGRAM_URL}")
    @NotNull
    @NotEmpty
    private String url;

    @Value("${TELEGRAM_MAX_CONNECTIONS:40}")
    @NotNull
    @NotEmpty
    private int maxConnections;

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxConnections() {
        return maxConnections;
    }
}

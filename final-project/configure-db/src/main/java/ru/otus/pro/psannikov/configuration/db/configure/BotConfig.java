package ru.otus.pro.psannikov.configuration.db.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.yml")
@Data
public class BotConfig {
    @Value("${telegram.bot.botUsername}")
    private String botName;
    @Value("${telegram.bot.token}")
    private String token;
    @Value("@${telegram.bot.chatId}")
    private String chatId;
    @Value("${telegram.bot.botMessageText}")
    private String botMessageText;
}

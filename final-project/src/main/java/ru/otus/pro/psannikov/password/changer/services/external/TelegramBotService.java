package ru.otus.pro.psannikov.password.changer.services.external;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
@Service
public class TelegramBotService extends TelegramLongPollingBot {
    String botName = "PasswordChangeHelperBot";
    String token = "6975911365:AAHUin1Ghglw3w-Nz8DTGbvGmPYgSOkaUDM";
    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Проверьте условия, чтобы определить, какой метод должен вызываться
        // и отправьте сообщение при помощи метода sendMessage
        SendMessage message = new SendMessage();
        message.setChatId(260406846L);
        message.setText("Kakojto tekst");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

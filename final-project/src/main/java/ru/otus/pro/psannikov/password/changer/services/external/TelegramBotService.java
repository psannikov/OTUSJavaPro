package ru.otus.pro.psannikov.password.changer.services.external;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotService extends TelegramLongPollingBot {
    //TODO переделать на чтение параметров из конфига
    String botName = "PasswordChangeHelperBot";
    String token = "6975911365:AAHUin1Ghglw3w-Nz8DTGbvGmPYgSOkaUDM";
    long chatId = 260406846L;
    public static final String BOT_MESSAGE_TEXT = "Kakojto tekst";


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
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(BOT_MESSAGE_TEXT);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

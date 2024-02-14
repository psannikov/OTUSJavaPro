package ru.otus.pro.psannikov.password.changer.services.external;

public class TelegramBotService {}
//extends TelegramLongPollingBot {
//    @Override
//    public String getBotUsername() {
//        @Value("${telegram.bot.botUsername}")
//        String botName;
//
//        return botName;
//    }
//
//    @Override
//    public String getBotToken() {
//        return "6975911365:AAHUin1Ghglw3w-Nz8DTGbvGmPYgSOkaUDM";
//    }
//
//    @Override
//    public void onUpdateReceived(Update update) {
//        // Проверьте условия, чтобы определить, какой метод должен вызываться
//        // и отправьте сообщение при помощи метода sendMessage
//        SendMessage message = new SendMessage();
//        message.setChatId(update.getMessage().getChatId());
//        message.setText("Kakojto tekst");
//        try {
//            execute(message);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//}

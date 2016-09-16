package xyz.ikuznetsov.bot;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 * Класс Telegram бота.
 */
public class TelegramBot extends TelegramLongPollingBot {
    /**
     * Метод определения входящего сообщения.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            try {
                handleIncomingMessage(message);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String getBotUsername() {
        return Configuration.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Configuration.BOT_TOKEN;
    }

    /**
     * Метод обработки входящего сообщения.
     */
    private void handleIncomingMessage(Message message) {

    }
}
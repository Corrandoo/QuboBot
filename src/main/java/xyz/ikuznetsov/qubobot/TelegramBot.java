package xyz.ikuznetsov.qubobot;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import xyz.ikuznetsov.qubobot.helper.MessageHelper;

import java.io.IOException;

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
            new Thread(() -> {
                try {
                    MessageHelper.handleIncomingMessage(update.getMessage());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
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
}

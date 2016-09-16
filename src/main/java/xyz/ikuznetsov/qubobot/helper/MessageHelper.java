package xyz.ikuznetsov.qubobot.helper;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.objects.Message;
import xyz.ikuznetsov.qubobot.manager.ChatManager;

public class MessageHelper implements Helper {
    /**
     * Метод обработки входящего сообщения.
     */
    public static void handleIncomingMessage(Message message) throws TelegramApiException {
        ChatManager.checkChat(message);
    }
}

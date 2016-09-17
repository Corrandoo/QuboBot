package xyz.ikuznetsov.qubobot.helper;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.objects.Message;
import xyz.ikuznetsov.qubobot.manager.ChatManager;
import xyz.ikuznetsov.qubobot.parser.GoogleParser;

import java.io.IOException;

public class MessageHelper implements Helper {
    /**
     * Метод обработки входящего сообщения.
     */
    private static boolean isQuestion(Message message){
        SimpleQuestion question = new SimpleQuestion();
        if(question.simpleQuestionDetector(message))
            return true;
        else return false;
    }
    public static void handleIncomingMessage(Message message) throws TelegramApiException, IOException {
        ChatManager.checkChat(message);
        if(isQuestion(message)){
            GoogleParser parser = new GoogleParser();
            String answer = parser.getInfo(message.getText());
        }

    }
}

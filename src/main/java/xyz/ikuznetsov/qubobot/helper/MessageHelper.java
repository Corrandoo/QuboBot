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
        /**
         * Я сделал небольшой рефактор, как видишь.
         * Теперь метод и все методы по мессаджам будут находиться в этом классе.
         * Я это сделал так, потому что мы ведь расчитываем добавить несколько бот-площадок в приложение?
         * Таким образом, очень удобно оставить класс бота как есть, а все рабочие методы выносить отдельно.
         * Я предлагаю тебе задание.
         * Реализуй стартовую логику этого метода. Этот метод - просто набор "ифов", которые вызывают другие методы.
         * Он должен по составным словам определить, что у нас хочет пользователь.
         * Я уже написал класс, который парсит гугл (лежит в parser). Разберись в нём, вызови нужные методы.
         * Эта задача в одно действие, поэтому не требует изменения "позиции" чата.
         * Парсер отвечает на вопросы вроде "кто такой...", "что такое...", "определение...", "...это" и т.д.
         * Кстати, обычного "контейнс" не достаточно! Пользователь может написать какую-нибудь несвязанную дичь,
         * в которой будет слово "это", и условие сработает, хотя не должно.
         * Из-за объёмов кода, все алгоритмы лучше выносить отдельно,
         * создав какой-нибудь класс "Признаки" и методы "естьЛиПризнакиПростогоВопроса", возвращающие тру-фалсе.
         * Это лишь маленький пример, твоя реализация может быть интереснее.
         * Фух... Написал. Ну что, стартуем! По техническим вопросам пишите на почту Владислава. Лучше в тг, лол.
         * Потом можешь стереть этот текст. :D
         */
        //TODO Реализовать этот метод (заставить работать с парсером). Подробнее выше.
        //ВОТ ЖЕ ПИЗДЕЦ.
    }
}

package xyz.ikuznetsov.qubobot.manager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.telegram.telegrambots.api.objects.Message;
import xyz.ikuznetsov.qubobot.HibernateSessionFactory;
import xyz.ikuznetsov.qubobot.Position;
import xyz.ikuznetsov.qubobot.dao.Chat;

/**
 * Методы для работы с чатами в базе данных.
 */
public class ChatManager implements Manager {
    /**
     * Проверка на наличие чата в базе данных.
     */
    public static void checkChat(Message message) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        long id = message.getChatId();
        Query query = session.createQuery("FROM Chat WHERE id=:id");
        query.setParameter("id", id);
        if (query.list().isEmpty() || query.list().size() == 0)
            addChat(message);
    }

    /**
     * Добавление чата в базу данных.
     */
    public static void addChat(Message message) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Chat chat = new Chat();
        chat.setId(message.getChatId());
        session.save(chat);
        session.getTransaction().commit();
    }

    /**
     * Установка последней позиции.
     */
    public static void setPosition(Message message, Position position) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Chat chat = session.get(Chat.class, message.getChatId());
        chat.setPosition(position.toString());
        session.merge(chat);
        session.getTransaction().commit();
    }
}

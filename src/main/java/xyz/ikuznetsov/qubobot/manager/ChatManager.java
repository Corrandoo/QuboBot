package xyz.ikuznetsov.qubobot.manager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.telegram.telegrambots.api.objects.Message;
import xyz.ikuznetsov.qubobot.HibernateSessionFactory;
import xyz.ikuznetsov.qubobot.dao.UsersEntity;

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
        Query query = session.createQuery("FROM UsersEntity WHERE id=:id");
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
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(message.getChatId());
        session.save(usersEntity);
        session.getTransaction().commit();
    }
}

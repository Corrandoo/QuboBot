package xyz.ikuznetsov.qubobot;

import org.hibernate.Session;
import org.telegram.telegrambots.api.objects.Message;
import xyz.ikuznetsov.qubobot.dao.UsersEntity;

public class ChatManager {
    public static void addChat(Message message){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(message.getChatId());
        session.save(usersEntity);
        session.getTransaction().commit();
    }
}

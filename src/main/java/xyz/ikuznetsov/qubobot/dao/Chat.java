package xyz.ikuznetsov.qubobot.dao;

import javax.persistence.*;

@Entity
@Table(name = "chats", schema = "a0086306_qubobot", catalog = "")
public class Chat {
    private long id;
    private String position;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat that = (Chat) o;

        if (id != that.id) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}

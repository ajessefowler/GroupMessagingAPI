package com.groupmessage.api.controllers.models;

import com.groupmessage.api.auth.models.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Message {
    private @Id @GeneratedValue Long id;
    private String content;
    private User origin;
    private Conversation conversation;
    private Date timestamp;
    private List<User> usersRead;

    public Message() {}

    public Message(String content, User origin, Conversation conversation, Date timestamp) {
        this.content = content;
        this.origin = origin;
        this.conversation = conversation;
        this.timestamp = timestamp;
    }

    public Long getId() { return this.id; }
    public String getContent() { return this.content; }
    public User getOrigin() { return this.origin; }
    public Conversation getConversation() { return this.conversation; }
    public Date getTimestamp() { return this.timestamp; }
    public List<User> getUsersRead() { return this.usersRead; }

    public void setId(Long id) { this.id = id; }
    public void setContent(String content) { this.content = content; }
    public void setOrigin(User origin) { this.origin = origin; }
    public void setConversation(Conversation conversation) { this.conversation = conversation; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
    public void setUsersRead(List<User> usersRead) { this.usersRead = usersRead; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  Message)) return false;

        Message message = (Message) o;

        return Objects.equals(this.id, message.id) &&
                Objects.equals(this.content, message.content) &&
                Objects.equals(this.origin, message.origin) &&
                Objects.equals(this.conversation, message.conversation) &&
                Objects.equals(this.timestamp, message.timestamp) &&
                Objects.equals(this.usersRead, message.usersRead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.content, this.origin, this.conversation,
                this.timestamp, this.usersRead);
    }

    @Override
    public String toString() {
        return "Message{id=" + this.id + ", content=" + this.content + ", origin= " + this.origin + ", conversation=" +
                this.conversation + ", timestamp=" + this.timestamp + ", usersRead=" + this.usersRead + "}";
    }
}

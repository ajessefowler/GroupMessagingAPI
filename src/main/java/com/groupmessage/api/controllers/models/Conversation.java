package com.groupmessage.api.controllers.models;

import com.groupmessage.api.auth.models.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

@Entity
public class Conversation {
    private @Id @GeneratedValue Long id;
    private Set<User> users;
    private Set<Message> messages;

    public Conversation() {}
    public Conversation(Set<User> users) { this.users = users; }

    public Long getId() { return this.id; }
    public Set<User> getUsers() { return this.users; }

    public void setId(Long id) { this.id = id; }
    public void setUsers(Set<User> users) { this.users = users; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  Conversation)) return false;

        Conversation conversation = (Conversation) o;

        return Objects.equals(this.id, conversation.id) &&
                Objects.equals(this.users, conversation.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.users);
    }

    @Override
    public String toString() {
        return "Conversation{id=" + this.id + ", users=" + this.users + "}";
    }
}

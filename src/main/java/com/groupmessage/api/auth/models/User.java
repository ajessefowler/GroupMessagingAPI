package com.groupmessage.api.auth.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable {
    private @Id @GeneratedValue Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String token;
    //private List<Conversation> conversations;

    public User() {}

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return this.id; }
    public String getUsername() { return this.username; }
    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public String getToken() { return this.token; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setToken(String token) { this.token = token; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return Objects.equals(this.id, user.id) &&
                Objects.equals(this.username, user.username) &&
                Objects.equals(this.firstName, user.firstName) &&
                Objects.equals(this.lastName, user.lastName) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.token, user.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.firstName,
                this.lastName, this.email, this.password, this.token);
    }

    @Override
    public String toString() {
        return "User: {id=" + this.id + ", username=" + this.username + ", firstName=" +
                this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + "}";
    }
}

package model.Entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany

    public User() {
    }
}

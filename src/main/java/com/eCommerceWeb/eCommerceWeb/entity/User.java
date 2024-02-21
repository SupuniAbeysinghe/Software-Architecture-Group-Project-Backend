package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String email;
    @Column
        private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

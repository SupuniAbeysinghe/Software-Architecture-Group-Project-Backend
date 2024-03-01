package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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

    public User(int id, String email, String firstName, String lastName, String address, String encode) {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toStringNew() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;


        public ShoppingCart getShoppingCart() {
            return shoppingCart;
        }


        public void setShoppingCart(ShoppingCart shoppingCart) {
            this.shoppingCart = shoppingCart;
        }

}

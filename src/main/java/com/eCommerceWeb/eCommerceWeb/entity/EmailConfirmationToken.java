//package com.eCommerceWeb.eCommerceWeb.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@Entity(name = "ConfirmationToken")
//public class EmailConfirmationToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false)
//    private String token;
//    @Column(nullable = false)
//    private LocalDateTime timeStamp;
//    @OneToOne
//    @JoinColumn(
//            nullable = false,
//            name = "id"
//    )
//    private User user;
//
//
//}

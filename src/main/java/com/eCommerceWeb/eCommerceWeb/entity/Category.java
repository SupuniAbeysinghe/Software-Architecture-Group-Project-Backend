package com.eCommerceWeb.eCommerceWeb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue//(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private  int category_id;
    private String name;

}

package com.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String category_name;

    @ManyToMany(mappedBy = "categories")
    private List<Movie> movie;
}

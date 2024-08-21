package com.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity
@Table
public class Yonetmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private String yonetmen_adi;

    @OneToMany(mappedBy = "yonetmen")
    private List<Movie> movie;
}


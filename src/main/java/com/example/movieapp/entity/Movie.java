package com.example.movieapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table
@Builder //builder desing patterini tüm constraksin olasılıklarına göre mothod yapar
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column()
    private String film_adi;
    @Column()
    private int imdb;


    //3.tabloyu oluşturduk çokaçok ilişkisi olduğu için
    @ManyToMany
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    //bağantıyı yöneten taraf burdaki yönetmen nesnesi o yüzden moviesavedtoya da koyduk
    @ManyToOne(cascade = CascadeType.ALL) //movie silince yönetmeni de silcek
    @JoinColumn(name = "yonetmen_id")
    private Yonetmen yonetmen;







}

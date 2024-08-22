package com.example.movieapp.repository;

import com.example.movieapp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAllByYonetmenId(Long yonetmenId);
}

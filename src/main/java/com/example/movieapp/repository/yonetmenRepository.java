package com.example.movieapp.repository;

import com.example.movieapp.entity.Yonetmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface yonetmenRepository extends JpaRepository<Yonetmen,Long> {
}

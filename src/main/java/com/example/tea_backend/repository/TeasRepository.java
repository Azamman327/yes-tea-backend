package com.example.tea_backend.repository;

import com.example.tea_backend.domain.Teas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeasRepository extends JpaRepository<Teas, Long> {
    Optional<Teas> findById(Long teaId);
}

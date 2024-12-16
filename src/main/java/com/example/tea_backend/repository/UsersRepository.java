package com.example.tea_backend.repository;

import com.example.tea_backend.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    //Optional : 찾는 객체가 없을 시 NULL 반환
    Optional<Users> findByUserId(long userId);

    @Query("SELECT users FROM Users users WHERE name = :name")
    Optional<Users> findByName(@Param("name")String name);
}

package com.notes.application.Notes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.notes.application.Notes.models.User;

import java.util.Optional;


@Repository("userRepo")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT s FROM user_table s WHERE s.email = ?1")
    Optional<User> findByEmail(String email);
}

package com.example.agrob.repository;


import com.example.agrob.model.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {
    Optional<MainUser> findMainUserByName(String name);
    Optional<MainUser> findMainUserByUsername(String username);
}

package com.example.agrob.service;



import com.example.agrob.model.MainUser;

import java.util.List;
import java.util.Optional;

public interface MainUserService {
    List<MainUser> findAll();
    Optional<MainUser> findById(Long id);
    Optional<MainUser> findUserByName(String name);
}

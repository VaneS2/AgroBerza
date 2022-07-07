package com.example.agrob.service.impl;


import com.example.agrob.model.MainUser;
import com.example.agrob.repository.MainUserRepository;
import com.example.agrob.service.MainUserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MainUserServiceImpl implements MainUserService {
    MainUserRepository mainUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public MainUserServiceImpl(MainUserRepository mainUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mainUserRepository = mainUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<MainUser> findAll() {
        return this.mainUserRepository.findAll();
    }

    @Override
    public Optional<MainUser> findById(Long id) {
        return this.mainUserRepository.findById(id);
    }

    @Override
    public Optional<MainUser> findUserByName(String name) {
        return this.mainUserRepository.findMainUserByName(name);
    }
}

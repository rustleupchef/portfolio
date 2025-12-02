package com.portfolio.portfolio;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    public void createUser(Users user) {
        usersRepository.saveUser(user);
    }

    public Users getUser(Long id) {
        return usersRepository.getUserById(id);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteUserById(id);
    }
}

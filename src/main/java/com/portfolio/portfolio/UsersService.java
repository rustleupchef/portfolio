package com.portfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    public void createUser(Users user) {
        usersRepository.saveUser(user);
    }

    public Users getUser(String username) {
        return usersRepository.getUserById(username);
    }

    public void deleteUser(String username) {
        usersRepository.deleteUserById(username);
    }

    public boolean userExists(String username) {
        return getUser(username) != null;
    }
}

package edu.eci.arsw.ecidraw.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.ecidraw.entities.Users;
import edu.eci.arsw.ecidraw.repositories.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public void delete(Users c) {
        usersRepository.delete(c);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Long findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }
}

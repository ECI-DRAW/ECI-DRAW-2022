package edu.eci.arsw.ecidraw.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.ecidraw.entities.UsersXSesion;
import edu.eci.arsw.ecidraw.repositories.UsersXSesionRepository;

@Service
public class UsersXSessionService {
    @Autowired
    private UsersXSesionRepository usersXSesionRepository;

    public UsersXSesion createUsersXSesion(UsersXSesion usersXSesion) {
        return usersXSesionRepository.save(usersXSesion);
    }

    public void delete(UsersXSesion c) {
        usersXSesionRepository.delete(c);
    }

    public List<UsersXSesion> getAllUsersXSesions() {
        return usersXSesionRepository.findAll();
    }

    public Optional<UsersXSesion> getUsersXSesionById(Long id) {
        return usersXSesionRepository.findById(id);
    }

    public List<UsersXSesion> getUsersXSesionByUser(Long id) {
        return usersXSesionRepository.getUsersXSessionByUserId(id);
    }

    public List<UsersXSesion> getUsersXSesionBySession(Long id) {
        return usersXSesionRepository.getUsersXSessionBySessionId(id);
    }
}

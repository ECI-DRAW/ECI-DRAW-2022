package edu.eci.arsw.ecidraw.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.ecidraw.entities.Users;
import edu.eci.arsw.ecidraw.services.UsersService;

@RestController
@RequestMapping(value = "/api/users")
public class UsersRest {

    @Autowired
    private UsersService usersService;

    @GetMapping("/getUserById")
    private ResponseEntity<Optional<Users>> getUserById(@PathParam("id") Long id) {
        Optional<Users> user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    private ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

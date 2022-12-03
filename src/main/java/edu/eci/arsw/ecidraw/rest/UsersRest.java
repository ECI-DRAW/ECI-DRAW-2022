package edu.eci.arsw.ecidraw.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.ecidraw.entities.Sesion;
import edu.eci.arsw.ecidraw.entities.Users;
import edu.eci.arsw.ecidraw.services.SesionService;
import edu.eci.arsw.ecidraw.services.UsersService;

@RestController
@RequestMapping(value = "/api/users")
public class UsersRest {

    @Autowired
    private UsersService usersService;
    private SesionService sesionService;

    @PostMapping("/newuser")
    private ResponseEntity<Users> createUser(@PathParam("username") String username) {
        Users user = new Users(username);
        try {
            return ResponseEntity.ok(usersService.createUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/newGuestUser")
    private ResponseEntity<Users> createGUser(@PathParam("username") String username,
            @PathParam("idSesion") Long idSesion) {
        try {
            usersService.insertUser(username, idSesion);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getUserById")
    private ResponseEntity<Optional<Users>> getUserById(@PathParam("id") Long id) {
        Optional<Users> user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getUserByName")
    private ResponseEntity<Long> getUserByName(@PathParam("username") String username) {
        Long user = usersService.findByUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    private ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

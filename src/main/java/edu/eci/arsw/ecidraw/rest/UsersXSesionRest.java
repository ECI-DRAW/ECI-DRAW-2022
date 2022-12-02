package edu.eci.arsw.ecidraw.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.ecidraw.entities.Users;
import edu.eci.arsw.ecidraw.entities.Sesion;
import edu.eci.arsw.ecidraw.entities.UsersXSesion;
import edu.eci.arsw.ecidraw.services.SesionService;
import edu.eci.arsw.ecidraw.services.UsersService;
import edu.eci.arsw.ecidraw.services.UsersXSessionService;

@RestController
@RequestMapping(value = "/api/usersxsesion")
public class UsersXSesionRest {
    @Autowired
    private SesionService sesionService;
    private UsersService usersService;
    private UsersXSessionService usersXSesionService;

    @PostMapping("/newUserXSesion")
    private ResponseEntity<UsersXSesion> newUsersXSesion(@PathParam("username") String username,
            @PathParam("idSesion") Long idSesion) {
        System.out.println("username: " + username);
        System.out.println("idSesion: " + idSesion);
        Optional<Sesion> sesion = sesionService.getSesionById(idSesion);
        System.out.println("sesion: " + sesion);
        Long user = usersService.findByUsername(username);
        System.out.println("user: " + user);
        Optional<Users> estesi = usersService.getUserById(user);
        UsersXSesion usersXSesion = new UsersXSesion(sesion.get(), estesi.get());
        return ResponseEntity.ok(usersXSesionService.createUsersXSesion(usersXSesion));
    }
}

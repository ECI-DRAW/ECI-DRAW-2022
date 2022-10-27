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

import edu.eci.arsw.ecidraw.entities.Sesion;
import edu.eci.arsw.ecidraw.services.SesionService;

@RestController
@RequestMapping(value = "/api/sesions")
public class SesionRest {

    @Autowired
    private SesionService sesionService;

    @PutMapping("/newsesion")
    private ResponseEntity<Sesion> createSesion(@PathParam("id") Long id, @PathParam("name") String name,
            @PathParam("answer") String answer) {
        Sesion sesion = sesionService.createSesion(id, name, answer);
        return ResponseEntity.ok(sesion);
    }

    @GetMapping("/getSesionById")
    private ResponseEntity<Optional<Sesion>> getSesionById(@PathParam("id") Long id) {
        Optional<Sesion> sesion = sesionService.getSesionById(id);
        return ResponseEntity.ok(sesion);
    }

    @GetMapping("/getAllSesions")
    private ResponseEntity<List<Sesion>> getAllSesions() {
        List<Sesion> sesions = sesionService.getAllSesions();
        return ResponseEntity.ok(sesions);
    }

    @GetMapping("/getSesionByName")
    private ResponseEntity<Optional<Sesion>> getSesionByName(@PathParam("name") String name) {
        Optional<Sesion> sesion = sesionService.getSesionByName(name);
        return ResponseEntity.ok(sesion);
    }

    @GetMapping("/getSesionByAnswer")
    private ResponseEntity<Optional<Sesion>> getSesionByAnswer(@PathParam("answer") String answer) {
        Optional<Sesion> sesion = sesionService.getSesionByAnswer(answer);
        return ResponseEntity.ok(sesion);
    }

}
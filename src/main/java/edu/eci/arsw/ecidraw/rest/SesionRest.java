package edu.eci.arsw.ecidraw.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.ecidraw.entities.Sesion;
import edu.eci.arsw.ecidraw.services.SesionService;

@RestController
@RequestMapping(value = "/api/sesions")
public class SesionRest {

    @Autowired
    private SesionService sesionService;

    @PostMapping("/newsesion")
    private ResponseEntity<Sesion> createSesion(@PathParam("idSesion") Long idSesion, @PathParam("hostn") String hostn,
            @PathParam("answer") String answer) {
        Sesion sesion = new Sesion(idSesion, hostn, answer);
        try {
            return ResponseEntity.ok(sesionService.createSesion(sesion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getSesionById")
    private ResponseEntity<Optional<Sesion>> getSesionById(@PathParam("id") Long id) {
        Optional<Sesion> sesion = sesionService.findById(id);
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

    @GetMapping("/getSesionAnswer")
    private ResponseEntity<Map<String, String>> getSesionAnswer(@PathParam("idSesion") Long idSesion) {
        try {
            String answer = sesionService.getSesionAnswer(idSesion);
            Map<String, String> respuesta = new HashMap<String, String>();
            respuesta.put("answer", answer);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

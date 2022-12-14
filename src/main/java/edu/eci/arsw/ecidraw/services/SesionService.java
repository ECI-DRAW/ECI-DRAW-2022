package edu.eci.arsw.ecidraw.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.ecidraw.entities.Sesion;
import edu.eci.arsw.ecidraw.repositories.SesionRepository;

@Service
public class SesionService {
    @Autowired
    private SesionRepository sesionRepository;

    /*
     * metodo que crea una sesion
     */
    public Sesion createSesion(Sesion sesion) {
        return sesionRepository.save(sesion);
    }

    public void delete(Sesion c) {
        sesionRepository.delete(c);
    }

    public List<Sesion> getAllSesions() {
        return sesionRepository.findAll();
    }

    public Optional<Sesion> getSesionByName(String hostn) {
        return sesionRepository.getSesionByName(hostn);
    }

    public Optional<Sesion> getSesionByAnswer(String answer) {
        return sesionRepository.getSesionByAnswer(answer);
    }

    public Optional<Sesion> findById(Long id) {
        return sesionRepository.findById(id);
    }

    public Optional<Sesion> getSesionById(Long idSesion) {
        return sesionRepository.getSesionById(idSesion);
    }

    public String getSesionAnswer(Long idSesion) {
        return sesionRepository.getSesionAnswer(idSesion);
    }
}

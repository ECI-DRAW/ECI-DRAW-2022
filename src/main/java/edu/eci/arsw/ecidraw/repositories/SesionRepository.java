package edu.eci.arsw.ecidraw.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.ecidraw.entities.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {

    /**
     * Busca una sesion por su nombre
     * 
     * @param name Nombre de la sesion
     * @return Sesion
     */
    @Query("SELECT c FROM Sesion c WHERE name=:name")
    Optional<Sesion> getSesionByName(@Param("name") String name);

    /**
     * Busca una sesion por su respuesta
     * 
     * @param answer Respuesta de la sesion
     * @return Sesion
     */
    @Query("SELECT c FROM Sesion c WHERE answer=:answer")
    Optional<Sesion> getSesionByAnswer(@Param("answer") String answer);

}

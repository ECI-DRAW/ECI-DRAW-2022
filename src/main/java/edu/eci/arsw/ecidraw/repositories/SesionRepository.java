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
    @Query("SELECT c FROM Sesion c WHERE hostn=:hostn")
    Optional<Sesion> getSesionByName(@Param("hostn") String hostn);

    /**
     * Busca una sesion por su respuesta
     * 
     * @param answer Respuesta de la sesion
     * @return Sesion
     */
    @Query("SELECT c FROM Sesion c WHERE answer=:answer")
    Optional<Sesion> getSesionByAnswer(@Param("answer") String answer);

    @Query("SELECT c FROM Sesion c WHERE idSesion=:idSesion")
    Optional<Sesion> getSesionById(@Param("idSesion") Long idSesion);

    @Query("SELECT answer FROM Sesion WHERE idSesion=:idSesion")
    String getSesionAnswer(@Param("idSesion") Long idSesion);

    /**
     * Inserta una sesion
     */
    @Query(value = "INSERT INTO sesion (id, host, answer) VALUES (:id, :host, :answer)", nativeQuery = true)
    void insertSesion(@Param("id") Long id, @Param("host") String name, @Param("answer") String answer);
}

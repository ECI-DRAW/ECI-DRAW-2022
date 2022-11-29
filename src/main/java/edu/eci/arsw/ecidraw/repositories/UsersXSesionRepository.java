package edu.eci.arsw.ecidraw.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.ecidraw.entities.UsersXSesion;

/**
 * UsersXSessionRepository
 */
@Repository
public interface UsersXSesionRepository extends JpaRepository<UsersXSesion, Long> {
    /**
     * Busca usuarios por su id
     */
    @Query("SELECT c FROM UsersXSesion c WHERE idUser=:idUser")
    List<UsersXSesion> getUsersXSessionByUserId(@Param("idUser") Long idUser);

    /**
     * Busca sesiones por su id
     */
    @Query("SELECT c FROM UsersXSesion c WHERE idSesion=:idSesion")
    List<UsersXSesion> getUsersXSessionBySessionId(@Param("idSesion") Long idSesion);

    /**
     * Busca usuarios por su id y sesion por su id
     */
    @Query("SELECT c FROM UsersXSesion c WHERE idUser=:idUser AND idSesion=:idSesion")
    Optional<UsersXSesion> getUsersXSessionByUserIdAndSessionId(@Param("idUser") Long idUser,
            @Param("idSesion") Long idSesion);
}

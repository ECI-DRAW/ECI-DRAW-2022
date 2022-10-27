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
    @Query("SELECT c FROM UsersXSesion c WHERE idUser=:userId")
    List<UsersXSesion> getUsersXSessionByUserId(@Param("userId") Long userId);

    /**
     * Busca sesiones por su id
     */
    @Query("SELECT c FROM UsersXSesion c WHERE idSesion=:sessionId")
    List<UsersXSesion> getUsersXSessionBySessionId(@Param("sessionId") Long sessionId);

    /**
     * Busca usuarios por su id y sesion por su id
     */
    @Query("SELECT c FROM UsersXSesion c WHERE idUser=:userId AND idSesion=:sessionId")
    Optional<UsersXSesion> getUsersXSessionByUserIdAndSessionId(@Param("userId") Long userId,
            @Param("sessionId") Long sessionId);
}

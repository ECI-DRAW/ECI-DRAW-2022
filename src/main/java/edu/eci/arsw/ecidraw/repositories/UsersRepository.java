package edu.eci.arsw.ecidraw.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.eci.arsw.ecidraw.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * Busca un usuario por su nombre
     * 
     * @param username Nombre del usuario
     * @return Usuario
     */
    @Query("SELECT idUser FROM Users WHERE username=:username")
    Long findByUsername(@Param("username") String username);

    // @Query("SELECT c FROM Users c WHERE id=:id")
    // Optional<Users> findByUsername(@Param("id") String id);

    /**
     * Inserta una sesion
     */
    @Modifying
    @Query(value = "INSERT INTO users (username, id_sesion) VALUES (:username, :id_sesion)", nativeQuery = true)
    @Transactional
    void insertUser(@Param("username") String username, @Param("id_sesion") Long id_sesion);

}

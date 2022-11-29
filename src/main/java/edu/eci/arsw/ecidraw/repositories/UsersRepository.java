package edu.eci.arsw.ecidraw.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.eci.arsw.ecidraw.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * Busca un usuario por su nombre
     * 
     * @param username Nombre del usuario
     * @return Usuario
     */
    @Query("SELECT c FROM Users c WHERE username=:username")
    Users findByUsername(@Param("username") String username);
}

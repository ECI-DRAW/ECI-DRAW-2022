package edu.eci.arsw.ecidraw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    /**
     * Identificador del usuario
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    /**
     * Columna de nombre del usuario
     */
    @Column(name = "username", nullable = false)
    private String username;

    // @ManyToOne
    // @JoinColumn(name = "idSesion", referencedColumnName = "idSesion")
    // private Sesion idSesion;

    public Users() {
    }

    public Users(Long idUser, String username) {
        this.idUser = idUser;
        this.username = username;
    }

    public Users(String username) {
        this.username = username;
    }

    // public Users(String username, Sesion idSesion) {
    // this.username = username;
    // this.idSesion = idSesion;
    // }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

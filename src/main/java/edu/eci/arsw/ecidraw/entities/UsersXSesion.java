package edu.eci.arsw.ecidraw.entities;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UsersXSesion")
public class UsersXSesion {

    @EmbeddedId
    private PrimaryUxS id;

    public UsersXSesion(PrimaryUxS id) {
        this.id = id;
    }

    public UsersXSesion(Sesion idSesion, Users idUser) {
        this.id = new PrimaryUxS(idSesion, idUser);
    }

    public PrimaryUxS getId() {
        return id;
    }

    public void setId(PrimaryUxS id) {
        this.id = id;
    }

    public Users getUser() {
        return id.getIdUser();
    }

    public void setUser(Users user) {
        this.id.setIdUser(user);
    }

    public Sesion getSesion() {
        return id.getIdSesion();
    }

    public void setSesion(Sesion sesion) {
        this.id.setIdSesion(sesion);
    }
}

@Embeddable
class PrimaryUxS implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idSesion", nullable = false, referencedColumnName = "idSesion")
    private Sesion idSesion;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users idUser;

    public PrimaryUxS() {
    }

    public PrimaryUxS(Sesion idSesion, Users idUser) {
        this.idSesion = idSesion;
        this.idUser = idUser;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Sesion getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Sesion idSesion) {
        this.idSesion = idSesion;
    }
}

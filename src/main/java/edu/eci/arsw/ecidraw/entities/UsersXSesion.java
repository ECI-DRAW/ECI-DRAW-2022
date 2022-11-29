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

    public UsersXSesion(Users idUser, Sesion idSesion) {
        this.id = new PrimaryUxS(idUser, idSesion);
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
    @JoinColumn(name = "idUser", nullable = false)
    private Users idUser;

    @ManyToOne
    @JoinColumn(name = "idSesion", nullable = false)
    private Sesion idSesion;

    public PrimaryUxS() {
    }

    public PrimaryUxS(Users idUser, Sesion idSesion) {
        this.idUser = idUser;
        this.idSesion = idSesion;
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

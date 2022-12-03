package edu.eci.arsw.ecidraw.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sesion")
public class Sesion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nSesion;

    /**
     * Columna id de la sesion
     */
    @Column(name = "idSesion", unique = true, nullable = false)
    private Long idSesion;

    /**
     * Nombre hostn de la sesion
     */

    @Column(name = "hostn", nullable = false)
    private String hostn;

    /**
     * Columna respuesta de la sesion
     */
    @Column(name = "answer", nullable = false)
    private String answer;

    public Sesion() {
    }

    public Sesion(Long idSesion, String hostn, String answer) {
        this.idSesion = idSesion;
        this.hostn = hostn;
        this.answer = answer;
    }

    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getName() {
        return hostn;
    }

    public void setName(String name) {
        this.hostn = name;
    }

}

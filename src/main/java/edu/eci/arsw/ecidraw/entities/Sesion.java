package edu.eci.arsw.ecidraw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Sesion")
public class Sesion implements Serializable {
    /**
     * Identificador de la sesion
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSesion;

    /**
     * Columna respuesta de la sesion
     */
    @Column(name = "answer", unique = true, nullable = false)
    private String answer;

    /**
     * Columna de nombre de la sesion
     */
    @Column(name = "name", nullable = false)
    private String name;

    public Sesion() {
    }

    public Sesion(Long idSesion, String answer, String name) {
        this.idSesion = idSesion;
        this.answer = answer;
        this.name = name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

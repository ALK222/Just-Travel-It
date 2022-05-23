package is2.justtravelit.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity de usuarios
 * 
 * @see javax.persistence.Entity
 */
@Entity
public class User {

    @Id
    private String name;
    private String password;
    private String nif;
    private String email;

    /**
     * @return Nombre del usuario
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return NIF del usuario
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif Nuevo NIF del usuario
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * @return Email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Nuevo email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param name Nuevo nombre del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param password Nueva contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

}

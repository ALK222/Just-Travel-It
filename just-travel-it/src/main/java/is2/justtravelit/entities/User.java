package is2.justtravelit.entities;

import javax.persistence.*;

import is2.justtravelit.dtos.UserDTO;

@Entity
public class User {

    @Id
    private String name;
    private String password;
    private String nif;
    private String email;
        

    public String getName() {
        return this.name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setNif(user.getNif());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}

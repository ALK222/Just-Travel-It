package is2.justtravelit.entities;

import javax.persistence.Id;

import is2.justtravelit.dtos.UserDTO;

/** Wrapper class for changes in the password of an user */
public class UserPasswordChange {
    @Id
    private String name;
    private String password;
    private String newPassword;

    public String getName() {
        return this.name;
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

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

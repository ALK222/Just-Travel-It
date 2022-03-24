package is2.justtravelit.dtos;

import is2.justtravelit.entities.User;

public class UserDTO {
    private String name;
    private String password;
    private String nif;
    private String email;

    public UserDTO(){

    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public UserDTO (String name){
        this.name = name;
    }

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

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getNif());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    
}

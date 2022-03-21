package is2.justtravelit.dtos;

import is2.justtravelit.entities.User;

public class UserDTO {
    private String name;
    private String password;

    public UserDTO(){

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
        return user;
    }

    
}

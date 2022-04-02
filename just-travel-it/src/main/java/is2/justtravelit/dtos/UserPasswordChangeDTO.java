package is2.justtravelit.dtos;

import is2.justtravelit.entities.UserPasswordChange;

public class UserPasswordChangeDTO {

    private String name;
    private String password;
    private String newPassword;

    public UserPasswordChangeDTO() {

    }

    public UserPasswordChangeDTO(String name) {
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

    public String getNewPassword() {
        return this.newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public static UserPasswordChange toEntity(UserPasswordChangeDTO userPasswordChangeDTO) {
        UserPasswordChange user = new UserPasswordChange();
        user.setName(userPasswordChangeDTO.getName());
        user.setPassword(userPasswordChangeDTO.getPassword());
        user.setNewPassword(userPasswordChangeDTO.getNewPassword());
        return user;
    }

}

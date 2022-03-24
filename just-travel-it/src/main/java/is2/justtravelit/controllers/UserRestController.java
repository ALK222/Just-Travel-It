package is2.justtravelit.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.services.UserService;


@RestController
public class UserRestController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO) {
        userDTO = userService.userValidation(userDTO);
        if (userDTO!=null) {
            try {
                return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> userSignUp(@RequestBody UserDTO userDTO) {
        userDTO = userService.userRegister(userDTO);
        if (userDTO.getName()!=null) {
            try {
                return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/showusers")
    public ResponseEntity<List<UserDTO>> usersShowAll(){
        return new ResponseEntity<List<UserDTO>>(userService.findAllUsers(), HttpStatus.ACCEPTED);
    }
    
}

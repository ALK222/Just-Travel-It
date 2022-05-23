package is2.justtravelit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import is2.justtravelit.dtos.UserDTO;
import is2.justtravelit.services.UserService;

/**
 * Controlador para todas las operaciones con usuarios
 * 
 * @see RestController
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * Log in de un usuario
     * 
     * @param userDTO Usuario a loggear
     * @return Usuario loggeado y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see UserDTO
     */
    @PostMapping("/login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO) {
        userDTO = userService.userValidation(userDTO);
        if (userDTO != null) {
            try {
                return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Cambio de contraseña para un usuario
     * 
     * @param userDTO Usuario con la contrasña actualizada
     * @return Usuario actualizado y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see UserDTO
     */
    @PutMapping("/user/newpassword")
    public ResponseEntity<UserDTO> userNewPassword(@RequestBody UserDTO userDTO) {
        UserDTO response = userService.changePassword(userDTO);
        if (response != null) {
            try {
                return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Registro de un nuevo usuario
     * 
     * @param userDTO Usuario a registrar
     * @return Usuario registrado y un código HTTP dependiendo del resultado de la
     *         operación
     * @see ResponseEntity
     * @see UserDTO
     */
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> userSignUp(@RequestBody UserDTO userDTO) {
        userDTO = userService.userRegister(userDTO);
        if (userDTO.getName() != null) {
            try {
                return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Muestra todos los usuarios disponibles en la base de datos
     * 
     * @return Listado de usuarios y un código HTTP dependiendo del resultado de
     *         la operación
     * @see ResponseEntity
     * @see UserDTO
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> usersShowAll() {
        return new ResponseEntity<List<UserDTO>>(userService.findAllUsers(), HttpStatus.ACCEPTED);
    }

}

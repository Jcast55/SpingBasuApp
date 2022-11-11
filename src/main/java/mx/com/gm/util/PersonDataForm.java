package mx.com.gm.util;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;

@Data
public class PersonDataForm {

    
    private long id;
    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    private String telefono;

    @NotNull
    private Double sueldo;

    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;

    @NotEmpty
    private String nameRol;

}

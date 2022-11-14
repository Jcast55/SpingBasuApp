package mx.com.gm.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import mx.com.gm.servicio.PersonaService;
import mx.com.gm.servicio.RolService;
import mx.com.gm.servicio.Uservice;
import mx.com.gm.util.EncriptarPassword;
import mx.com.gm.util.PersonDataForm;

@Slf4j
@Controller
@RequestMapping("/agregar")
public class AgregarController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private RolService rolService;
    @Autowired
    private Uservice uService;

    @GetMapping
    public String agregar(PersonDataForm PersonDataForm) {
        return "agregarPerson";
    }

    @PostMapping()
    public String guardar(@ModelAttribute PersonDataForm personaDataForm, Errors errores) {
        if (errores.hasErrors()) {
            return "agregarPerson";
        }
        Usuario userC = new Usuario();
        String passwordEncrip = EncriptarPassword.encriptarPassword(personaDataForm.getPassword());

        userC.setPassword(passwordEncrip);
        userC.setUsername(personaDataForm.getUsername());
        userC = uService.userSave(userC);
        Rol rol = new Rol();
        rol.setNombre(personaDataForm.getNameRol());
        rol.setUsuario(userC);
        Persona persona = new Persona();
        persona.setApellido(personaDataForm.getApellido());
        persona.setEmail(personaDataForm.getEmail());
        persona.setNombre(personaDataForm.getNombre());
        persona.setSueldo(personaDataForm.getSueldo());
        persona.setTelefono(personaDataForm.getTelefono());
        persona.setUser(userC);
        rolService.rolSave(rol);
        personaService.guardar(persona);
     
        return "redirect:/";
    }

}

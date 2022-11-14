package mx.com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/editar")
public class EditarController {
    @Autowired
    private PersonaService personaService;
    @Autowired
    private RolService rolService;
    @Autowired
    private Uservice uService;


    @GetMapping("persona/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        PersonDataForm personDataForm = new PersonDataForm();
        personDataForm.setId(persona.getIdPersona());
        personDataForm.setApellido(persona.getApellido());
        personDataForm.setEmail(persona.getEmail());
        String nombreRol = persona.getUser().getRoles().get(0).getNombre();
        personDataForm.setNameRol(nombreRol);
        personDataForm.setNombre(persona.getNombre());
        personDataForm.setSueldo(persona.getSueldo());
        personDataForm.setTelefono(persona.getTelefono());
        personDataForm.setUsername(persona.getUser().getUsername());
        model.addAttribute("personaDataForm", personDataForm);
        return "modificar";
    }
    @PostMapping()
    public String guardar(@ModelAttribute PersonDataForm personaDataForm, Errors errores) {
        if (errores.hasErrors() || personaDataForm.getId() == 0L) {
            return "modificar";
        }
        Persona persona = personaService.findByIdPersona(personaDataForm.getId());
        Usuario userC = persona.getUser();
        String passwordEncrip = EncriptarPassword.encriptarPassword(personaDataForm.getPassword());

        userC.setPassword(passwordEncrip);
        userC.setUsername(personaDataForm.getUsername());
        userC = uService.userSave(userC);

        Rol rol = persona.getUser().getRoles().get(0);
        rol.setNombre(personaDataForm.getNameRol());
        rol.setUsuario(userC);
        rolService.rolSave(rol);

        persona.setApellido(personaDataForm.getApellido());
        persona.setEmail(personaDataForm.getEmail());
        persona.setNombre(personaDataForm.getNombre());
        persona.setSueldo(personaDataForm.getSueldo());
        persona.setTelefono(personaDataForm.getTelefono());
        persona.setUser(userC);
        personaService.guardar(persona);
     
        return "redirect:/";
    }
}

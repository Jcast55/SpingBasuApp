package mx.com.gm.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
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
import mx.com.gm.servicio.PersonaService;
import mx.com.gm.servicio.RolService;
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
    private UserDetailsService uService;


    @GetMapping
    public String agregar(PersonDataForm PersonDataForm) {
        return "agregarPerson";
    }

    @PostMapping()
    public String guardar(@ModelAttribute  PersonDataForm personaDataForm, Errors errores) {
        if (errores.hasErrors()) {
            return "agregarPerson";
        }
       // log.info("Persona:  " + persona.toString());
        log.info("Persona:  " + personaDataForm.toString());
       // personaService.guardar(persona);
        return "redirect:/";
    }




    
}

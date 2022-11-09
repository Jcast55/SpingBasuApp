package mx.com.gm.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Rol;
import mx.com.gm.servicio.PersonaService;
import mx.com.gm.servicio.RolService;

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


    @GetMapping()
    public String agregar(Persona persona, Model model) {
        List<String> options = new ArrayList<String>();
        options.add("ROLE_USER");
        options.add("ROLE_GUEST");
        model.addAttribute("options", options);
        return "modificar";
    }

    @PostMapping("/persona")
    public String guardar(@Valid Persona persona, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        log.info("Persona:  " + persona.toString());
        String pass = (String) model.getAttribute("pass");
        String user = (String) model.getAttribute("userName");
        Rol rol = (Rol) model.getAttribute("rol");
        
        log.info("pass: " +  pass + "    User: " +  user );
        log.info("rol: " + rol.getNombre());
       // personaService.guardar(persona);
        return "redirect:/";
    }




    
}

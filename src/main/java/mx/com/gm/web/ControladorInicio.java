package mx.com.gm.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.domain.Rol;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        var saldoTotal = 0D;
        for (var p : personas) {
            saldoTotal += p.getSueldo();
        }
        model.addAttribute("sueldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }
/* 
    @GetMapping("/agregar")
    public String agregar(Persona persona, Model model) {
        List<String> options = new ArrayList<String>();
        options.add("ROLE_USER");
        options.add("ROLE_GUEST");
        model.addAttribute("options", options);
        return "modificar";
    }
*/
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        List<Rol> roles = persona.getUser().getRoles();
        List<String> options = new ArrayList<String>();
        if (roles.size() != 0 && !roles.isEmpty()) {

            for (Rol rol : roles) {
                options.add(rol.getNombre());
            }
        } else {
            options.add("ROLE_USER");
            options.add("ROLE_GUEST");
        }
        model.addAttribute("persona", persona);
        model.addAttribute("options", options);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(@PathVariable("idPersona") long idPersona) {
        personaService.eliminar(personaService.findByIdPersona(idPersona));
        return "redirect:/";
    }
}

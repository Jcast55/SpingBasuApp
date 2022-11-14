package mx.com.gm.web;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonaService personaService;

    @GetMapping()
    public String inicio(@AuthenticationPrincipal User user, Model model) {
        
        return "index";
    }


    @GetMapping("/cliente")

    public String inicioCliente(@AuthenticationPrincipal User user){
        return "cliente";
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
    
    */

    @GetMapping("/vehiculo")
    public String inicioVehiculo(@AuthenticationPrincipal User user){
        return "vehiculo";
    }
/*   ------    trabajador -------- */
    @GetMapping("/trabajador")
    public String inicioTrabajador(@AuthenticationPrincipal User user, Model model) {
        List<Persona> personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);
        return "trabajador";
    }



/*   ------    fin -------- */

    @GetMapping("/gasto")
    public String inicioGasto(@AuthenticationPrincipal User user) {
        return "gasto";
    }

    @GetMapping("/credito")
    public String iniciocredito(@AuthenticationPrincipal User user) {
        return "credito";
    }

    @GetMapping("/cobro")
    public String inicioCobro(@AuthenticationPrincipal User user) {
        return "cobro";
    }

    @GetMapping("/ruta")
    public String inicioRuta(@AuthenticationPrincipal User user) {
        return "ruta";
    }

    @GetMapping("/admin")
    public String inicioAdmin(@AuthenticationPrincipal User user) {
        return "admin";
    }

    @GetMapping("/reporte")
    public String inicioReporte(@AuthenticationPrincipal User user) {
        return "reporte";
    }


    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(@PathVariable("idPersona") long idPersona) {
        personaService.eliminar(personaService.findByIdPersona(idPersona));
        return "redirect:/";
    }
}

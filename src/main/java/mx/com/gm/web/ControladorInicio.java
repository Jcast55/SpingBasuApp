package mx.com.gm.web;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.servicio.PersonaService;
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
    public String inicio(@AuthenticationPrincipal User user) {
   
        return "index";
    }


    @GetMapping("/cliente")
    public String inicioCliente(@AuthenticationPrincipal User user){
        return "cliente";
    }

    @GetMapping("/vehiculo")
    public String inicioVehiculo(@AuthenticationPrincipal User user){
        return "vehiculo";
    }

    @GetMapping("/trabajador")
    public String inicioTrabajador(@AuthenticationPrincipal User user) {
        return "trabajador";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(@PathVariable("idPersona") long idPersona) {
        personaService.eliminar(personaService.findByIdPersona(idPersona));
        return "redirect:/";
    }
}
